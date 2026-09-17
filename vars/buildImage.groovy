#!/user/bin/env groovy

def call(String imageName, String location) {
    echo "building the docker image for $location"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh "docker build -t $imageName ./$location"
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push $imageName"
    }
}
