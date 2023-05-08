pipeline {

   agent any 
   stages 
   {
       
            stage('Build Jar')
            
            {
       
                steps 
                {
                   bat "mvn clean package -DskipTests"
             
                }
            }
            
             stage('Build Image')
            
            {
       
                steps 
                {
                   bat "docker build -t='neopane1/finalone' ."
             
                }
            }
            
             stage('Push Image')
            
            {
       
                steps 
                {
                   withCredentials([usernamePassword(credentialsId: 'jenkinseopane1', passwordVariable:'pass', usernameVariable:'user')])
                   {
                     bat "docker login --username=${user} --password=${pass}"
                     bat "docker push neopane1/finalone:latest"
                   }
                }
            }
   
   }



}