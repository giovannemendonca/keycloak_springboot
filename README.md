# Projeto Spring Boot com Keycloak

Este projeto é uma API Spring Boot integrada ao Keycloak para autenticação e autorização.

## Pré-requisitos

- Docker instalado
- Maven instalado
- Navegador web

## Iniciando o Keycloak

Execute o seguinte comando para iniciar o Keycloak usando Docker:

```bash
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:23.0.1 start-dev
```

## Criando o Realm

Acesse o Keycloak em http://localhost:8080 e faça login com o usuário `admin` e senha `admin`.

Clique em `Add realm` e crie um novo realm com o nome `spring-boot-keycloak`.

## Criando o Client

Clique em `Clients` e depois em `Create`.

Preencha o campo `Client ID` com o valor `spring-boot-keycloak-client` e clique em `Save`.

Na aba `Settings`, preencha o campo `Valid Redirect URIs` com o valor `http://localhost:8081/*` e clique em `Save`.

## Criando o usuário

Clique em `Users` e depois em `Add user`.

Preencha o campo `Username` com o valor `user` e clique em `Save`.

Na aba `Credentials`, preencha o campo `Password` com o valor `user` e clique em `Set Password`.

Na aba `Role Mappings`, selecione o `spring-boot-keycloak-client` no campo `Client Roles` e selecione a role `user` no campo `Available Roles` e clique em `Add selected`.

## Executando o projeto

Execute o seguinte comando para iniciar o projeto:

```bash
mvn spring-boot:run
```

## Testando o projeto

Acesse o postman e importe a collection `spring-boot-keycloak.postman_collection.json`.
