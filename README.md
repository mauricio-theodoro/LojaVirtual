# 🛍️ Loja Virtual

## 📌 Descrição

O projeto **Loja Virtual** é uma aplicação web desenvolvida com **Spring Boot** que gerencia produtos e categorias utilizando persistência de dados com **MariaDB**. A aplicação oferece operações CRUD por meio de uma API RESTful e adota boas práticas de arquitetura, com separação entre as camadas de `Controller`, `Service` e `Repository`.

Este projeto foi criado para fins acadêmicos, com foco na correta aplicação do JPA e integração com banco de dados relacional.

---

## ⚙️ Tecnologias Utilizadas

- Java 11+
- Spring Boot 3.x
- Spring Data JPA & Hibernate
- MariaDB (via MariaDB JDBC Driver)
- Maven

---

## ✅ Pré-requisitos

- Java JDK 11 ou superior
- Maven instalado
- MariaDB instalado (pode ser via XAMPP, Docker ou standalone)

---

## 🛠️ Instalação e Configuração

### 1. Instale o MariaDB

Você pode baixar diretamente do [site oficial do MariaDB](https://mariadb.org/download/) ou instalar via XAMPP (recomendado para iniciantes).

### 2. Crie o banco de dados

Acesse o console do MariaDB e execute:

```sql
CREATE DATABASE lojadigitaldb
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
```

### 3. Configure a conexão no `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/lojadigitaldb
    username: root
    password: your_password_here
    driver-class-name: org.mariadb.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        jdbc:
          time_zone: UTC

server:
  port: 8080

spring:
  sql:
    init:
      mode: always
```

> 💡 Substitua `your_password_here` pela sua senha do MariaDB.

---

## 🗂️ Estrutura do Projeto

```
LojaVirtual/
├── pom.xml                      # Configuração do Maven
├── mvnw, mvnw.cmd              # Maven Wrapper
├── .mvn/                       # Configurações do Maven
├── src/
│   ├── main/
│   │   ├── java/com/lojadigital/
│   │   │   ├── controller/     # Endpoints REST
│   │   │   ├── model/          # Entidades JPA
│   │   │   ├── repository/     # Interfaces do Spring Data
│   │   │   └── service/        # Lógica de negócio
│   │   └── resources/
│   │       └── application.yml # Configurações da aplicação
│   └── test/                   # Testes (opcional)
└── README.md                   # Este arquivo
```

---

## ▶️ Executando o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/mauricio-theodoro/LojaVirtual.git
cd LojaVirtual
```

### 2. Compile e execute

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação será iniciada na porta `8080`.

---

## 🧪 Testando a API

Você pode utilizar ferramentas como **Postman** ou **cURL**.

### 🔹 Endpoints - Categoria

| Método | Endpoint                             | Descrição                    |
|--------|--------------------------------------|------------------------------|
| GET    | `/api/v1/categorias`                 | Listar todas as categorias   |
| GET    | `/api/v1/categorias/{id}`            | Buscar por ID                |
| POST   | `/api/v1/categorias`                 | Criar nova categoria         |
| PUT    | `/api/v1/categorias/{id}`            | Atualizar categoria existente|
| DELETE | `/api/v1/categorias/{id}`            | Deletar categoria            |

**Exemplo JSON:**

```json
{
  "nome": "Eletrônicos",
  "descricao": "Categoria destinada a produtos eletrônicos"
}
```

### 🔹 Endpoints - Produto

| Método | Endpoint                            | Descrição                     |
|--------|-------------------------------------|-------------------------------|
| GET    | `/api/v1/produtos`                  | Listar todos os produtos      |
| GET    | `/api/v1/produtos/{id}`             | Buscar produto por ID         |
| POST   | `/api/v1/produtos`                  | Criar novo produto            |
| PUT    | `/api/v1/produtos/{id}`             | Atualizar produto existente   |
| DELETE | `/api/v1/produtos/{id}`             | Deletar produto               |

**Exemplo JSON:**

```json
{
  "nome": "Smartphone XYZ",
  "preco": 1500.0,
  "descricao": "Smartphone com excelentes recursos",
  "categoria": { "id": 1 }
}
```

---

## 📌 Considerações Finais

- Em ambiente de **desenvolvimento**, o `ddl-auto: update` facilita a criação automática das tabelas.
- Para **produção**, recomenda-se o uso de ferramentas como Flyway ou Liquibase para controle de versionamento de schema.

---

## 🤝 Contribuindo

Sinta-se à vontade para abrir uma **issue** ou enviar um **Pull Request** com sugestões de melhoria!

---

## 📬 Contato

Caso tenha dúvidas ou sugestões, entre em contato pelo GitHub ou abra uma issue neste repositório.
