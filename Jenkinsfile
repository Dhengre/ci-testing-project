pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/<user>/selenium-k8s-ci.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t selenium-tests .'
            }
        }

        stage('Push Image') {
            steps {
                sh '''
                docker tag selenium-tests registry/selenium-tests:latest
                docker push registry/selenium-tests:latest
                '''
            }
        }

        stage('Run Tests on Kubernetes') {
            steps {
                sh '''
                kubectl apply -f selenium-test-job.yaml
                kubectl wait --for=condition=complete job/selenium-tests
                '''
            }
        }
    }

    post {
        success {
            echo 'K8s Selenium Tests Passed'
        }
        failure {
            echo 'K8s Selenium Tests Failed'
        }
    }
}
