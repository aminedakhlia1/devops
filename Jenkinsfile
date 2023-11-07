pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'amine',
                url: 'https://github.com/aminedakhlia1/devops.git'
            }
        }
   
   
      stage('Nettoyage et compilation avec Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                // Étape de compilation du projet
                sh "mvn compile"
                // Etape de sonar
            }
        }
                       stage('MVN SONARQUBE'){
        steps {
            sh "mvn sonar:sonar -Dsonar.login=sqa_df72b24d6adc61685d016b7ae95e9c5c9b8aada6"
        }
        }


    }
}
