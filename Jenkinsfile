pipeline {
    agent any

    // environment {
    //     APP_SERVER = "3.110.201.22"
    //     USER = "ec2-user"
    //     JAR_NAME = "java-sample-21-1.0.0.jar"
    //     APP_DIR = "/opt/myapp"
    //     JAVA_HOME = '/usr/lib/jvm/java-21-openjdk'
    //     PATH = "${JAVA_HOME}/bin:${env.PATH}"
    // }

    stages {

        stage('Check Java Version') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
                sh 'echo $JAVA_HOME'
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

        stage('Deploy to App Server') {
            steps {
                sshagent(['app-server']) {
                    sh """
scp -o StrictHostKeyChecking=no javaapp-pipeline/target/${JAR_NAME} ec2-user@${APP_SERVER}:/tmp/

ssh -o StrictHostKeyChecking=no ec2-user@${APP_SERVER} <<EOF
sudo mkdir -p ${APP_DIR}
sudo mv /tmp/${JAR_NAME} ${APP_DIR}/myapp.jar

if pgrep -f "java -jar myapp.jar" > /dev/null; then
    sudo pkill -f "java -jar myapp.jar"
    echo "Old application stopped"
fi

sudo nohup java -jar ${APP_DIR}/myapp.jar > ${APP_DIR}/app.log 2>&1 &
echo "Application started"
EOF
"""
                }
            }
        }
    }

    post {
        success {
            echo "Build, Test, and Deployment successful!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
