pipeline {
    agent any
  environment {
    DOCKERHUB_CREDENTIALS=credentials('projet')
    }
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
        stage('Docker Image') {
                           steps {
                               sh 'docker build -t yosrdahmani-5sae3-g4 .'
                           }
               }        
                stage('DOCKERHUB') {
                          steps {
                              sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                              sh 'docker tag yosrdahmani-5sae3-g4 yosr1997/yosr-5sae3-g4:1.0.0'
                              sh 'docker push yosr1997/yosr-5sae3-g4:1.0.0'
                          }
                      }
               stage('Docker Compose') {
                                  steps {
                                      sh 'docker compose up -d'
                                  }
                      }

    }
}
