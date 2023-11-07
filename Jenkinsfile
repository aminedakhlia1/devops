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
                       stage('MVN SONARQUBE'){
        steps {
            sh "mvn sonar:sonar -Dsonar.login=sqa_df72b24d6adc61685d016b7ae95e9c5c9b8aada6"
        }
        }
        stage('nexus'){
            steps {
                sh "mvn deploy"
            }
         }
        stage('Docker Image') {
                           steps {
                               sh 'docker build -t aminedakhlia-5sae3-g4 .'
                           }
               }        
                stage('DOCKERHUB') {
                          steps {
                              sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                              sh 'docker tag aminedakhlia-5sae3-g4 aminedakhlia1/amine-5sae3-g4:1.0.0'
                              sh 'docker push aminedakhlia1/amine-5sae3-g4:1.0.0'
                          }
                      }
               stage('Docker Compose') {
                                  steps {
                                      sh 'docker compose up -d'
                                  }
                      }
    }
}
