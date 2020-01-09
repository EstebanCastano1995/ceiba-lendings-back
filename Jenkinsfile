pipeline{
  agent any
   options { //Mantener artefactos y salida de consola para el # específico de ejecuciones recientes del Pipeline.  
      buildDiscarder(logRotator(numToKeepStr: '3')) //No permitir ejecuciones concurrentes de Pipeline  
      disableConcurrentBuilds()
   }
   tools {
      jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master     
      gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master   } 
      //Aquí comienzan los “items” del Pipeline
   }
  stages {
                        stage('Checkout') {
                            steps{
                            echo "------------>Checkout<------------"
                            checkout([
                            $class: 'GitSCM',
                            branches: [[name: '*/master']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [],
                            gitTool: 'Git_Centos',
                            submoduleCfg: [],
                            userRemoteConfigs: [[
                            credentialsId: 'GitHub_EstebanCastano95',
                            url:'https://github.com/EstebanCastano1995/ceiba-lendings-back.git'
                            ]]
                            ])
                            }
                        }
                        stage('Build project') {
                           steps {
                              echo "------------>Building project<------------"
                              sh 'gradle --b ./build.gradle clean'
                              sh 'gradle --b ./build.gradle build'
                           }
                        }
                        stage('Compile & Unit Tests') {
                           steps {
                              echo "--------------->Unit Tests<--------"
                              sh 'gradle --b ./build.gradle test'
                              sh 'gradle --b ./build.gradle jacocoTestReport'
                           }
                        }
                        stage('Static Code Analysys'){
                           steps {
                              echo '----------------->Analisis de Código estático<-----------------'
                              withSonarQubeEnv('Sonar'){
                                 sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                              }
                           }
                        }
                        stage('Build') {
                           steps {
                              echo "-------->Build<---------"
                              sh 'gradle --b ./build.gradle build -x test'
                           }
                        }         
         }
         post {
            success{
               echo 'This will run only if successfull'
               junit 'ceiba-lendings-back/build/test-results/test/*.xml'
            }
            failure {
               echo 'This will run only if failed'
               mail(to: 'esteban.castano@ceiba.com.co',
                  subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                  body: "Something is wrong with ${env.BUILD_URL}")
            }
         }
 }