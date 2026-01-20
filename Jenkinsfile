pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        IMAGE = "milind061/spring-boot-jenkins-docker-image:${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/Milind-Jha/jenkins.git',
                    branch: 'dockerbranch'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                      echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                      docker push $IMAGE
                    '''
                }
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                  docker rm -f spring-boot-app || true
                  docker run -d --name spring-boot-app -p 8282:1212 $IMAGE
                '''
            }
        }
    }
}
