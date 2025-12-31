pipeline {
    agent any

    // Poll Git SCM every minute
    triggers {
        pollSCM('* * * * *')
    }

    environment {
        // Example environment variable for tests
        ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from SCM
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Run Maven tests quietly
                sh 'mvn -q clean test'
            }
        }
    }

    post {
        always {
            // Publish JUnit test results
            junit 'target/surefire-reports/*.xml'
            
            // Optional: minimal console message
            echo "Pipeline finished. Check test results above."
        }

        success {
            echo "Build and tests succeeded!"
        }

        failure {
            echo "Build or tests failed!"
        }
    }
}
