pipeline{
    agent{
        label "master"
    }
    stages{
        stage("Build"){
            steps{
                sh "export PATH=/opt/gradle/bin:${PATH}"
                sh "./gradlew clean build"
            }
            post{
                always{
                    echo "========always========"
                }
                success{
                    echo "========A executed successfully========"
                }
                failure{
                    echo "========A execution failed========"
                }
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}