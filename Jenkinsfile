pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               sh 'mvn clean package'
               echo 'Build success.'
            }
        }
        stage('Deploy') {
            steps {
               sh 'Je deploie'
            }
        }
    }
}