pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin"
        IMAGE_VERSION = "1.0.${BUILD_NUMBER}"
        IMAGE_NAME = "milind061/spring-boot-jenkins-docker-image"
    }

    tools {
        maven "maven"
    }

    stages {

        stage("Checkout from Github") {
            steps {
                checkout scmGit(
                    branches: [[name: '*/dockerbranch']],
                    userRemoteConfigs: [[url: 'https://github.com/Milind-Jha/jenkins.git']]
                )
            }
        }

        stage("Building jar") {
            steps {
                sh 'mvn clean install'
            }
        }

        stage("Cleanup Old Container & Image") {
            steps {
                sh '''
                  docker rm -f spring-app || true
                  docker rmi -f ${IMAGE_NAME} || true
                '''
            }
        }

        stage("Building Docker Image") {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_VERSION} .'
            }
        }

        stage("Deploy to docker hub") {
            steps {
                withCredentials([string(credentialsId: 'dp', variable: 'DP')]) {
                    sh '''
                      echo "$DP" | docker login -u milind061 --password-stdin
                      docker push ${IMAGE_NAME}:${IMAGE_VERSION}
                    '''
                }
            }
        }

        stage("Run Application") {
            steps {
                sh '''
                  docker run -d \
                    -p 1212:1212 \
                    --name spring-app \
                    ${IMAGE_NAME}:${IMAGE_VERSION}
                '''
            }
        }
    }
}
