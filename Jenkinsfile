pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven3'  // Name from Step 1
                    sh "${mvnHome}/bin/mvn -q clean test"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            echo 'Build or tests finished!'
        }
    }
}
