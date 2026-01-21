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
        stage("Building Docker Image"){
            steps{
                script{
                    sh 'docker build -t milind061/spring-boot-jenkins-docker-image:1.0 .'
                }
            }
        }
        stage("Deploy to docker hub"){
            steps{
                 withCredentials([string(credentialsId: 'dp', variable: 'dp')]) {
                 sh 'docker login -u milind061 -p ${dp}'
                 sh 'docker push milind061/spring-boot-jenkins-docker-image:1.0'
                 }
            }
        }
    }
}
