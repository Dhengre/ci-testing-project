pipeline {
    agent any

    tools {
        maven 'Maven3'   // Must match Jenkins Global Tool Configuration
    }

    stages {

        stage('Checkout Source Code') {
            steps {
                echo '📥 Checking out code from GitHub...'
                checkout scm
            }
        }

        stage('Build & Run Tests') {
            steps {
                echo '🧪 Running Maven build and tests...'
                sh '''
                    echo "----------------------------------------"
                    echo "Starting Maven Clean & Test"
                    echo "----------------------------------------"
                    mvn clean test
                '''
            }
        }
    }

    post {

        success {
            echo '✅ BUILD SUCCESS'
            echo '🎉 All test cases PASSED'
        }

        failure {
            echo '❌ BUILD FAILED'
            echo '⚠️ One or more test cases FAILED'
            echo '👉 Check test output above for details'
        }

        always {
            echo '📄 Publishing test reports...'
            junit 'target/surefire-reports/*.xml'
            echo '🏁 Pipeline execution finished'
        }
    }
}
