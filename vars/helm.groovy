def install(Map args, Boolean dry_run=true){
    def values_map = []
    String values, values_file, namespace, dry_run_parameter = "--dry-run"
    if (!dry_run){
        println("DRY_RUN DISABLED!")
        dry_run_parameter = ""
    }
    println(dry_run)
    println("DRY_RUN_PARAMETER:  " + dry_run_parameter)
    if (args.containsKey("values_file")) {
        if (args.values_file) {
            values_file = " -f ${args.values_file}"
        }
        else {
            values_file = ""
        }
    }
    else {
        values_file = ""
    }
    if (args.containsKey("namespace")) {
        namespace = " --namespace=${args.namespace}"
    }
    else {
        namespace = ""
    }
    if (args.containsKey("values")) {
        for (value in args.values) {
            values_map.add("$value.key=$value.value")
        }
        values = "--set ${values_map.join(',')}"
    }
    else {
        values = ""
    }
    sh "helm upgrade ${dry_run_parameter} --wait --install ${args.chart_name} ${args.chart_path} ${values} ${values_file} ${namespace} --timeout 30m0s"
}

def lint(helm_chart_path){
    sh "helm lint ${helm_chart_path}/"
}