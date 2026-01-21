pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin:/opt/homebrew/bin:/usr/bin:/bin:/usr/sbin:/sbin"
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

        stage("Building Docker Image") {
            steps {
                sh 'docker --version'
                sh 'docker build -t milind061/spring-boot-jenkins-docker-image:1.0 .'
            }
        }

        stage("Deploy to docker hub") {
            steps {
                withCredentials([string(credentialsId: 'dp', variable: 'DP')]) {
                    sh '''
                      echo "$DP" | docker login -u milind061 --password-stdin
                      docker push milind061/spring-boot-jenkins-docker-image:1.0
                    '''
                }
            }
        }
    }
}
