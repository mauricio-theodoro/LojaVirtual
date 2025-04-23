Loja Virtual

✨ Descrição

O projeto Loja Virtual é uma aplicação web desenvolvida com Spring Boot que permite o gerenciamento de produtos e categorias utilizando MariaDB como banco de dados relacional. A aplicação oferece operações CRUD completas por meio de uma API RESTful, estruturada com boas práticas de arquitetura, separando claramente as camadas de Controller, Service e Repository.

Este projeto foi desenvolvido como parte de uma avaliação acadêmica com foco em mapeamento JPA e integração com banco de dados relacional.

🫠 Tecnologias Utilizadas

Java 11+

Spring Boot 3.x

Spring Data JPA + Hibernate

MariaDB (com o driver MariaDB JDBC)

Maven

✅ Pré-requisitos

Java SDK 11 ou superior instalado

Maven instalado e configurado

Servidor MariaDB (pode ser instalado separadamente ou via XAMPP)

⚙️ Instalação e Configuração do Banco de Dados

1. Instale o MariaDB

Baixe do site oficial do MariaDB, ou use o XAMPP para instalação rápida.

2. Crie o banco de dados

CREATE DATABASE lojadigitaldb
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

3. Configure o application.yml

Arquivo localizado em: LojaVirtual/src/main/resources/application.yml

spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/lojadigitaldb
    username: root
    password:
    driver-class-name: org.mariadb.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
   

⚠️ Substitua your_password_here pela senha correta do seu banco de dados.

📁 Estrutura do Projeto

LojaVirtual/
├── pom.xml                  # Arquivo de configuração do Maven
├── mvnw, mvnw.cmd          # Maven Wrapper
├── .mvn/                   # Configurações do Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/com/lojadigital/
│   │   │   ├── controller/    # Endpoints REST
│   │   │   ├── model/         # Entidades: Produto, Categoria
│   │   │   ├── repository/    # Interfaces JPA
│   │   │   └── service/       # Regras de negócio
│   │   └── resources/
│   │       └── application.yml
│   └── test/                  # Testes unitários (se aplicável)
└── README.md

🚀 Executando o Projeto

1. Clone o repositório

git clone https://github.com/mauricio-theodoro/LojaVirtual.git
cd LojaVirtual

2. Compile e execute

mvn clean install
mvn spring-boot:run

A aplicação será iniciada na porta 8080. Confira os logs no terminal para ver se as tabelas foram criadas automaticamente.

📝 Endpoints da API

× Categoria

GET /api/v1/categorias — Listar todas as categorias

GET /api/v1/categorias/{id} — Buscar categoria por ID

POST /api/v1/categorias — Criar nova categoria

{
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral"
}

PUT /api/v1/categorias/{id} — Atualizar categoria existente

DELETE /api/v1/categorias/{id} — Deletar categoria

📦 Produto

GET /api/v1/produtos — Listar todos os produtos

GET /api/v1/produtos/{id} — Buscar produto por ID

POST /api/v1/produtos — Criar novo produto

{
  "nome": "Smartphone XYZ",
  "preco": 1500.0,
  "descricao": "Smartphone com excelentes recursos",
  "categoria": {
    "id": 1
  }
}

PUT /api/v1/produtos/{id} — Atualizar produto existente

DELETE /api/v1/produtos/{id} — Deletar produto

Use ferramentas como Postman, Insomnia ou cURL para testar os endpoints.

💡 Considerações Finais

Ambiente de desenvolvimento vs produção: O uso de ddl-auto: update é conveniente para desenvolvimento, mas em produção recomenda-se utilizar ferramentas como Flyway ou Liquibase.

Contribuição: A estrutura do projeto está preparada para expansão e manutenção. Fique à vontade para abrir uma issue ou enviar um pull request 🚀.

Contato: Dúvidas ou sugestões? Entre em contato via GitHub ou abra uma issue neste repositório.

Desenvolvido por Maurício Theodoro
