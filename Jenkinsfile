pipeline {
    agent any

    tools {
        maven 'Maven3'   // must match the name in Global Tool Configuration
        jdk 'JDK17'      // must match the name in Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Dhengre/ci-testing-project.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test -U'
            }
        }

        stage('Publish Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success { echo 'Tests passed!' }
        failure { echo 'Tests failed!' }
    }
}
