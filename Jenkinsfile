pipeline {
    agent any
 tools{
    maven 'maven'
    }
    stages {

      stage('clean')
            {
                steps
                 { 
                    sh 'mvn clean install'
                 }
            }
     stage('Deploy to Tomcat'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'Tomcat', passwordVariable: 'password', usernameVariable: 'username'),string(credentialsId: 'Tomcat_URL', variable: 'tomcat_url')]){
                    sh 'curl ${tomcat_url}/manager/text/undeploy?path=/SpringBootApp -u ${username}:${password}'
                    sh 'curl -v -u ${username}:${password} -T target/SpringBootApp-0.0.1-SNAPSHOT.war ${tomcat_url}/manager/text/deploy?path=/SpringBootApp'
                }
            }    
     }

}
    
    post { 
         success { 
            echo 'notified to slack '
            slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#springbootapp', color: '#00FF00', message: 'Application Deployed Successfully', teamDomain: 'Demo', tokenCredentialId: 'Slack' 
            }
         failure {
            echo 'notified to slack'
            slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#springbootapp', color: '#FF0000', message: 'Application Deployed Fail', teamDomain: 'Demo', tokenCredentialId: 'Slack'            
                 }
    }
}
