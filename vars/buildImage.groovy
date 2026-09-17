#!/user/bin/env groovy
import com.example.Docker
def call(String imageName, String location){
    return new Docker(this).buildDockerImage(imageName, location)
}

