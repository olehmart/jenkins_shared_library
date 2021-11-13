
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
                    def instance = Jenkins.getInstance()
                    def provider = instance.getExtensionList('org.jenkinsci.plugins.configfiles.json.JsonConfig$JsonConfigProvider')[0]
                    def config = new org.jenkinsci.plugins.configfiles.json.JsonConfig("test", "Config for test", "test config", "{content}")
                    provider.save(config)
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
