FROM maven:3.9.10-eclipse-temurin-21 AS build
# Esta linha define a imagem base: estamos usando a imagem oficial do Maven versão 3.9.10 com o Java 21 (Eclipse Temurin).
# AS build define uma etapa de construção nomeada como “build” (usado em builds multi-estágio).

WORKDIR /app
# Define o diretório de trabalho dentro do contêiner como /app.

COPY pom.xml .
# Copia o arquivo pom.xml (que define as dependências do Maven) para o diretório de trabalho atual no contêiner.

RUN mvn dependency:go-offline -B
# Executa o comando Maven para baixar todas as dependências definidas no pom.xml.
# -B significa “batch mode” (modo sem interação).
# dependency:go-offline baixa todas as dependências para que possamos construir offline.
# Esta etapa aproveita o cache em camadas do Docker, assim não precisamos baixar as dependências novamente se apenas o código-fonte mudar.

COPY src ./src
# Copia a pasta src (código-fonte) para o diretório de trabalho no contêiner.

RUN mvn clean package -DskipTests
# -DskipTests pula a execução de testes para agilizar o processo de build.

RUN mkdir -p /app/data && chmod -R 777 /app/data
# Cria um diretório data dentro da pasta /app.
# Define permissões totais (leitura, escrita e execução) para todos os usuários.
# Isso é necessário para que a aplicação possa escrever dados, mesmo rodando como um usuário não-root.

FROM gcr.io/distroless/java21-debian12:nonroot
# Inicia a segunda fase do build multi-estágio.
# Usa uma imagem “distroless” do Google que contém apenas o runtime Java 21, sem shell nem outras utilidades.
# nonroot indica que a imagem já está configurada para executar como usuário não privilegiado.
# Isso reduz significativamente a superfície de ataque da imagem.

LABEL maintainer="Delivery Tech Team"
# Adiciona metadados à imagem indicando quem é o mantenedor.

COPY --from=build /app/target/*.jar /app/delivery-api.jar
# Copia o arquivo JAR gerado na etapa “build” para a nova imagem.
#Apenas o arquivo JAR é copiado, não o código-fonte nem as dependências temporárias de build.

USER nonroot:nonroot
# Define que o contêiner deve executar como usuário nonroot (segurança).

WORKDIR /app
# Define o diretório de trabalho para /app na nova imagem.

EXPOSE 8080
# Informa que a aplicação dentro do contêiner escuta na porta 8080.
# Note que isso é apenas documentação, não publica realmente a porta.

ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-Dspring.profiles.active=docker", "-jar", "/app/delivery-api.jar"]
# Define o comando que será executado quando o contêiner iniciar:
# - "java": comando para executar a JVM;
# - "-Xms256m": memória heap inicial definida para 256 megabytes;
# - "-Xmx512m": memória heap máxima definida para 512 megabytes;
# - "-Dspring.profiles.active=docker": ativa o perfil “docker” do Spring Boot;
# - "-jar", "/app/delivery-api.jar": executa o arquivo JAR da aplicação.