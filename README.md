# Loja Virtual

## Descrição

O projeto **Loja Virtual** é uma aplicação web construida com **Spring Boot** para gerenciar produtos e categorias utilizando persistência de dados com **MariaDB**. A aplicação implementa operações CRUD por meio de uma API RESTful e adota as melhores práticas de arquitetura, com uma clara separação entre as camadas de _Controller_, _Service_ e _Repository_. Este projeto foi desenvolvido para atender os requisitos de uma avaliação acadêmica, demonstrando a correta implementação de mapeamento JPA e integração com o banco de dados.

## Tecnologias Utilizadas

- Java 11+ (compatível com sua JDK instalada)
- Spring Boot 3.x
- Spring Data JPA e Hibernate
- MariaDB (utilizando o driver MariaDB JDBC)
- Maven

## Pré-requisitos

- **Java SDK**: Certifique-se de que o Java (versão 11 ou superior) esteja instalado.
- **Maven**: Necessário para compilar e executar o projeto.
- **MariaDB**: Pode ser instalado de forma independente ou via XAMPP.

## Instalação e Configuração do MariaDB

1. **Instalação**:
   - Se ainda não tiver o MariaDB, faça o download no [site oficial](https://mariadb.org/download/) ou instale-o via XAMPP.

2. **Configuração**:
   - Após a instalação, inicie o serviço do MariaDB e abra o console do banco.
   - Crie o banco de dados necessário para o projeto executando o comando:

     ```sql
     CREATE DATABASE lojadigitaldb
     CHARACTER SET utf8mb4
     COLLATE utf8mb4_unicode_ci;
     ```

3. **Ajuste nas Configurações do Projeto**:
   - No arquivo [`LojaVirtual/application.yml`](LojaVirtual/application.yml), verifique se os dados de conexão estão configurados corretamente:

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

     **Nota:** Substitua `your_password_here` pela senha correta do usuário _root_ (ou o usuário configurado).

## Estrutura do Projeto

A organização do repositório é a seguinte:

. ├── README.md # Este arquivo com as instruções e informações do projeto └── LojaVirtual/ # Contém todo o código-fonte da aplicação ├── pom.xml # Gerenciamento de dependências e configuração do Maven ├── mvnw, mvnw.cmd # Scripts do Maven Wrapper ├── .mvn/ # Configurações do Maven Wrapper └── src/ ├── main/ │ ├── java/com/lojadigital/ │ │ ├── controller/ # Endpoints REST para Categoria e Produto │ │ ├── model/ # Entidades: Categoria e Produto │ │ ├── repository/ # Interfaces de repositório (Spring Data JPA) │ │ └── service/ # Camada de serviço (lógica de negócio) │ └── resources/ │ └── application.yml # Configurações da aplicação (datasource, JPA, etc.) └── test/ # Testes (caso haja)


## Executando o Projeto

1. **Clone o Repositório**
   
   Execute o comando abaixo no terminal para clonar o repositório:

   ```bash
   git clone https://github.com/mauricio-theodoro/LojaVirtual.git
Navegue até a Pasta do Projeto

bash
cd LojaVirtual
Compile e Execute a Aplicação

Execute os seguintes comandos para compilar e iniciar o projeto:

bash
mvn clean install
mvn spring-boot:run
A aplicação iniciará na porta 8080. Verifique os logs do console para confirmar que o Hibernate criou/atualizou as tabelas conforme as entidades definidas.

Testando os Endpoints
A API disponibiliza os seguintes endpoints para operações de CRUD:

Categoria
Listar Todas as Categorias

http
GET http://localhost:8080/api/v1/categorias
Buscar Categoria por ID

http
GET http://localhost:8080/api/v1/categorias/{id}
Criar Nova Categoria

http
POST http://localhost:8080/api/v1/categorias
Exemplo de JSON:

json
{
    "nome": "Eletrônicos",
    "descricao": "Categoria destinada a produtos eletrônicos"
}
Atualizar Categoria

http
PUT http://localhost:8080/api/v1/categorias/{id}
Deletar Categoria

http
DELETE http://localhost:8080/api/v1/categorias/{id}
Produto
Listar Todos os Produtos

http
GET http://localhost:8080/api/v1/produtos
Buscar Produto por ID

http
GET http://localhost:8080/api/v1/produtos/{id}
Criar Novo Produto

http
POST http://localhost:8080/api/v1/produtos
Exemplo de JSON:

json
{
    "nome": "Smartphone XYZ",
    "preco": 1500.0,
    "descricao": "Smartphone com excelentes recursos",
    "categoria": { "id": 1 }
}
Atualizar Produto

http
PUT http://localhost:8080/api/v1/produtos/{id}
Deletar Produto

http
DELETE http://localhost:8080/api/v1/produtos/{id}
Você pode testar essas requisições utilizando ferramentas como Postman ou cURL.

Considerações Finais
Ambiente de Desenvolvimento versus Produção: Em ambiente de desenvolvimento, o uso de ddl-auto: update é conveniente para criar e atualizar tabelas conforme as mudanças nas entidades. Em produção, recomenda-se o uso de ferramentas de migração de schema, como Flyway ou Liquibase, para um controle mais rigoroso das alterações no banco de dados.

Estrutura e Manutenção: A aplicação está organizada em camadas para facilitar a manutenção, testes e futuras expansões. Caso deseje contribuir, sinta-se à vontade para abrir Issues ou Pull Requests.

Contato: Para dúvidas ou sugestões, entre em contato ou abra uma issue neste repositório.
