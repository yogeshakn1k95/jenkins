pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/yogeshakn1k95/jenkins.git'
            }
        }
        stage('Test') {
            steps {
                dir('javaapp-standalone') {
                    sh 'mvn clean test'
                }
            }
        }
        stage('Build') {
            steps {
                dir('javaapp-standalone') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Deploy') {
            steps {
                dir('javaapp-standalone/target') {
                    sh '''
                        if pgrep -f "java -jar java-sample-21-1.0.0.jar" > /dev/null; then
                            pkill -f "java -jar java-sample-21-1.0.0.jar"
                            echo "App was running and has been killed"
                        else
                            echo "App is not running"
                        fi
                        JENKINS_NODE_COOKIE=dontKillme nohup java -jar java-sample-21-1.0.0.jar > app.log 2>&1 &
                    '''
                }
            }
        }
    }
}
