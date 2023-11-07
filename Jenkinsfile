pipeline {
    agent any
  
    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'yosr',
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
            sh "mvn sonar:sonar -Dsonar.login=sqa_f7a71596f03fa07cca77c72b3e50bcf32070c376"
        }
        }
        stage('mvn deploy'){
            steps {
                sh "mvn deploy"
            }
         }


    }
}
