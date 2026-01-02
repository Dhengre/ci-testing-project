pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
            }
        }

        stage('Run Automation Tests') {
            steps {
                echo 'Running tests...'
            }
        }
    }

    post {
        failure {
            echo '❌ Automation Failed'
        }
        success {
            echo '✅ Automation Passed'
        }
    }
}
