String content = ""
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
                    content = sh(script: "cat CICD.json", returnStdout: true).trim()
                    def instance = Jenkins.getInstance()
                    def provider = instance.getExtensionList('org.jenkinsci.plugins.configfiles.json.JsonConfig$JsonConfigProvider')[0]
                    def config = new org.jenkinsci.plugins.configfiles.json.JsonConfig("global_cicd_config", "Global config for CICD", "Global config for CICD", "${content}")
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
