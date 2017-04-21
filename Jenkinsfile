node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/codecentric/TDDTrainingApplication.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'maven'
      
     env.JAVA_HOME="${tool 'JDK8'}"
     env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
     sh 'java -version'
   }
   // A minor change in the fole
   stage('Build') {
      // Move into directory
      dir('TDDTrainingApplicationCC') {
      // Run the maven build
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
