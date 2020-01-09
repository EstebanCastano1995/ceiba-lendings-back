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
                              sh 'gradle --b ./ceiba-lendings-back/build.gradle clean'
                              sh 'gradle --b ./ceiba-lendings-back/build.gradle build'
                           }
                        }
                        stage('Compile & Unit Tests') {
                           steps {
                              echo "--------------->Unit Tests<--------"
                              sh 'gradle --b ./ceiba-lendings-back/build.gradle test'
                              sh 'gradle --b ./ceiba-lendings-back/build.gradle jacocoTestReport'
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
                              sh 'gradle --b ./ceiba-lendings-back/build.gradle build -x test'
                           }
                        }         
         }
         post {
            always {
               echo 'This always run'
            }
            success{
               echo 'This will run only if successfull'
               junit 'ceiba-lendings-back/build/test-results/test/*.xml'
            }
            failure {
               echo 'This will run only if failed'
               mail(to: 'daniel.castro@ceiba.com.co',
                  subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                  body: "Something is wrong with ${env.BUILD_URL}")
            }
            unstable {
               echo 'This will run only if the run was marked as unstable'
            }
            changed {
               echo 'This will run only if the state of the pipeline has changed'
               echo 'For example, if the Pipeline was previously failing but is now successfull'
            }
         }
 }
© 2020 GitHub, Inc.