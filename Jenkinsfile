pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'Java-17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/<your-username>/ci-testing-project.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ci-test-image .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                sh 'docker run --rm ci-test-image'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'All tests passed'
        }
        failure {
            echo 'Tests failed'
        }
    }
}
