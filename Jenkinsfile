pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    options {
        timestamps()
    }

    stages {

        stage('Checkout Source') {
            steps {
                echo 'Checking out source code from GitHub...'
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven build and tests...'

                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    sh '''
                        echo "====================================="
                        echo " Starting Maven Clean Test "
                        echo "====================================="
                        mvn clean test
                        echo "====================================="
                        echo " Maven execution completed "
                        echo "====================================="
                    '''
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            echo 'Pipeline execution finished!'
        }

        success {
            echo 'BUILD SUCCESS ✅'
        }

        failure {
            echo 'BUILD FAILED ❌ - Check test results above'
        }
    }
}
