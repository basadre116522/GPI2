pipeline {
    agent any
    stages {
        stage('Clone sources') {
            steps {
                git url: 'https://github.com/basadre116522/GPI2.git'
            }
        }
        stage('Build Android') {
            steps {
                dir('practica5/ActivityA116522') {
                    sh './gradlew assembleDebug'
                }
            }
        }
        stage('Build simple') {
            steps {
                dir('practica5/simple') {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test simple') {
            steps {
                dir('practica5/simple') {
                    sh 'mvn test'
                }
            }
        }
        stage('Build simple-webapp') {
            steps {
                dir('practica5/simple-webapp') {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test simple-webapp') {
            steps {
                dir('practica5/simple-webapp') {
                    sh 'mvn test'
                }
            }
        }
        stage('Make Arduino') {
            steps {
                dir('practica5/MyArduinoProject/src/FooProject') {
                    sh 'make'
                }
            }
        }
    }
}
