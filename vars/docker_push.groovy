def call(String Project, String ImageTag, String DockerHubUser){
    withCredentials([usernamePassword(
                    'credentialsId':"dockerHubCred",
                    passwordVariable:"dockerHubPass",
                    usernameVariable:"dockerHubUser")]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    }
                sh "docker push ${env.dockerHubUser}/notes-app:latest"
}
