pipeline {
    agent any
    
    tools {
        // Define o Maven versão 3 (M3) como uma ferramenta global no Jenkins
        maven "M3"
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout do repositório Git na branch main
                git branch: 'main', url: 'https://github.com/ex188929/inf335-trabalho5p1.git'
            }
        }
        
        stage('Build') {
            steps {
                // Utiliza o Maven para compilar o projeto e ignorar falhas de teste
                sh "cd meu-app; mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
    
    post {
        success {                   
            // Executa o comando junit para analisar os resultados dos testes
            junit '**/meu-app/target/surefire-reports/TEST-*.xml'

            // Salva os artefatos gerados
            archiveArtifacts 'meu-app/target/*.jar'
        }
        
    }
}

