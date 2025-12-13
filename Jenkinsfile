pipeline{
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage("Checkout from Github"){
            steps{
                checkout scmGit(branches: [[name: '*/dockerbranch']], extensions: [], userRemoteConfigs:[[url: 'https://github.com/Milind-Jha/jenkins.git']])
            }
        }
        stage("Building jar"){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }
        stages("Building Docker Image"){
            steps{
                script{
                    sh 'docker build -t milind061/spring-boot-jenkins-docker-image:1.0 .'
                }
            }
        }
    }
}