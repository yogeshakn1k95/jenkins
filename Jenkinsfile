// pipeline in repo

pipeline {
    agent any

    environment {
        JAR_NAME = "java-sample-21-1.0.0.jar"
        APP_DIR = "/opt/myapp"
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Check Java & Maven') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Build') {
            steps {
                dir('javaapp-pipeline') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('javaapp-pipeline') {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy Locally') {
            steps {
                sh """
                sudo mkdir -p ${APP_DIR}
                sudo cp javaapp-pipeline/target/${JAR_NAME} ${APP_DIR}/myapp.jar

                if pgrep -f "java -jar myapp.jar" > /dev/null; then
                    sudo pkill -f "java -jar myapp.jar"
                    echo "Old application stopped"
                fi

                sudo nohup java -jar ${APP_DIR}/myapp.jar > ${APP_DIR}/app.log 2>&1 &
                echo "Application started locally"
                """
            }
        }
    }

    post {
        success {
            echo "Build, Test, and Local Deployment successful!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
