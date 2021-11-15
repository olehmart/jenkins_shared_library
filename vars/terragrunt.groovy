def run(tg_command){
    sh "terragrunt run-all ${tg_command} --terragrunt-non-interactive"
}