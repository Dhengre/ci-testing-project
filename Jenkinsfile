pipeline {
    agent any

    tools {
        maven 'Maven3'   // must match the name in Global Tool Configuration
        jdk 'JDK17'      // must match the name in Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -q test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success { echo 'Tests passed!' }
        failure { echo 'Tests failed!' }
    }
}
