# 🛍️ Loja Virtual

## 📌 Descrição

O projeto **Loja Virtual** é uma aplicação web desenvolvida com **Spring Boot** que gerencia produtos e categorias utilizando persistência de dados com **MariaDB**. A API RESTful oferece operações CRUD completas, estruturada em camadas (_Controller_, _Service_, _Repository_) e utiliza **DTOs** para comunicação, garantindo segurança e controle de serialização.

Este projeto foi desenvolvido para fins acadêmicos, com foco em boas práticas JPA, tratamento centralizado de exceções e arquitetura limpa.

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
- MariaDB instalado (via XAMPP, Docker ou standalone)

---

## 🛠️ Instalação e Configuração

### 1. Instalar o MariaDB

Baixe pelo [site oficial do MariaDB](https://mariadb.org/download/) ou utilize XAMPP.

### 2. Criar o banco de dados

Conecte-se ao MariaDB e execute:

```sql
CREATE DATABASE lojadigitaldb
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar `application.yml`

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
├── pom.xml                  # Dependências e plugins do Maven
├── src/
│   ├── main/
│   │   ├── java/com/loja/digital/
│   │   │   ├── controller/   # Controllers REST
│   │   │   ├── dto/          # Data Transfer Objects
│   │   │   ├── exception/    # Exceptions customizadas
│   │   │   ├── model/        # Entidades JPA
│   │   │   ├── repository/   # Repositórios JPA
│   │   │   ├── service/      # Interfaces Service
│   │   │   └── service/impl/ # Implementações Service
│   │   └── resources/
│   │       └── application.yml
│   └── test/                 # Testes unitários e de integração
└── README.md                # Documentação do projeto
```

---

## ▶️ Executando o Projeto

1. Clone o repositório
   ```bash
git clone https://github.com/mauricio-theodoro/LojaVirtual.git
cd LojaVirtual
```
2. Compile e execute
   ```bash
mvn clean install
mvn spring-boot:run
```
A aplicação ficará disponível em `http://localhost:8080`.

---

## 🧪 Testando a API

Use **Postman** ou **cURL**. A URL base é:

```
http://localhost:8080/api/v1
```

### 🔹 Endpoints - Categoria (DTO)

| Método | Endpoint                       | Descrição                          |
|--------|--------------------------------|------------------------------------|
| GET    | `/categorias`                  | Listar todas as categorias         |
| GET    | `/categorias/{id}`             | Buscar categoria por ID            |
| POST   | `/categorias`                  | Criar nova categoria               |
| PUT    | `/categorias/{id}`             | Atualizar categoria existente      |
| DELETE | `/categorias/{id}`             | Deletar categoria                  |

**Exemplo JSON (CategoriaDTO):**
```json
{
  "nome": "Eletrônicos",
  "descricao": "Categoria destinada a produtos eletrônicos"
}
```

### 🔹 Endpoints - Produto (DTO)

| Método | Endpoint                      | Descrição                          |
|--------|-------------------------------|------------------------------------|
| GET    | `/produtos`                   | Listar todos os produtos           |
| GET    | `/produtos/{id}`              | Buscar produto por ID              |
| POST   | `/produtos`                   | Criar novo produto                 |
| PUT    | `/produtos/{id}`              | Atualizar produto existente        |
| DELETE | `/produtos/{id}`              | Deletar produto                    |

**Exemplo JSON (ProdutoDTO):**
```json
{
  "nome": "Smartphone XYZ",
  "preco": 1500.0,
  "descricao": "Smartphone com excelentes recursos",
  "categoriaId": 1
}
```

---

## ❗ Tratamento de Erros

- **ResourceNotFoundException** → retorna HTTP 404
- **@ControllerAdvice** para validação retorna HTTP 400 com detalhes

---

## 📌 Considerações Finais

- Em **desenvolvimento**, `ddl-auto: update` agiliza mudanças de esquema
- Em **produção**, use **Flyway** ou **Liquibase** para versionamento de banco

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Abra uma issue ou envie um pull request.

---

## 📬 Contato

Desenvolvido por [Mauricio Theodoro](https://github.com/mauricio-theodoro)
