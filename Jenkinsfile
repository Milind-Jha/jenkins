pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage("Checkout from Github") {
            steps {
                checkout scmGit(
                    branches: [[name: '*/nodb']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/Milind-Jha/jenkins.git']]
                )
            }
        }

        stage("Build using maven") {
            steps {
                sh 'mvn clean install'
            }
        }

        stage("Deploy on tomcat") {
            steps {
                deploy adapters: [
                    tomcat9(
                        alternativeDeploymentContext: '',
                        credentialsId: 'tomcat-pwd',
                        path: '',
                        url: 'http://localhost:9090/'
                    )
                ],
                contextPath: 'spring-boot-jenkins',
                war: '**/*.war'
            }
        }
    }
}
