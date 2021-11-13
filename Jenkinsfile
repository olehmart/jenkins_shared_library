
pipeline {
    agent {
        node {
            label 'slave'
        }
    }
    options {
        ansiColor('xterm')
    }
    stages {
        stage("Init") {
            steps {
                script {
                    def gcf = org.jenkinsci.plugins.configfiles.GlobalConfigFiles.get()
                    def deploymentFile = gcf.newConfig("test", "test", "test", "test")
                }
            }
        }
    }
    post {
        always {
            script {
                cleanWs()
                sh 'echo "Workspace has been cleaned up!"'
            }
        }
    }
}
