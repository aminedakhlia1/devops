pipeline {
    agent any
  environment {
    DOCKERHUB_CREDENTIALS=credentials('projet')
    }
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


    }
}
