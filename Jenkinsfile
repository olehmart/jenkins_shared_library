
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
                sh "ls -l"
                script {
                    def instance = Jenkins.getInstance()
                    String fileContents = new File('CICD.json').text
                    def provider = instance.getExtensionList('org.jenkinsci.plugins.configfiles.json.JsonConfig$JsonConfigProvider')[0]
                    def config = new org.jenkinsci.plugins.configfiles.json.JsonConfig("test", "Config for test", "test config", "${fileContents}")
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
