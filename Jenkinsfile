pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-org/selenium-docker-ci.git',
                    branch: 'main'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t selenium-tests:latest .'
            }
        }

        stage('Run Automation Tests') {
            steps {
                sh 'docker run --rm selenium-tests:latest'
            }
            post {
                always {
                    junit '**/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo '✅ Automation Passed'
        }
        failure {
            echo '❌ Automation Failed'
        }
    }
}
