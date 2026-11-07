pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "/opt/maven/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Source code is available in the workspace'
                sh 'git --version'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'

            archiveArtifacts allowEmptyArchive: true,
                             artifacts: 'target/*.jar'
        }

        success {
            echo 'Student API CI Pipeline Completed Successfully!'
        }

        failure {
            echo 'Student API CI Pipeline Failed!'
        }
    }
}
