pipeline {
    agent any

    tools {
        maven 'Maven'   // Jenkins Global Tool Configuration name
    }

    options {
        timestamps()   // Show timestamps in console
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

                // catchError ensures console output is shown even if tests fail
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
            echo 'Publishing test reports...'
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
