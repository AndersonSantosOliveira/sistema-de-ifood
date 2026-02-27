# MiniFood - Sistema de Delivery

## Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA / Hibernate  
- MySQL 8  
- Docker  
- Maven  

## Estrutura do Projeto

```plaintext
src/main/java/br/com/adsuema/minifood/
├── controller/    # Endpoints REST
├── model/         # Entidades do banco
├── repository/    # Repositórios JPA
└── service/       # Regras de negócio

Endpoints Principais
Restaurantes
GET /restaurante - Lista todos os restaurantes
GET /restaurante/{id} - Busca restaurante por ID
POST /restaurante - Cria um novo restaurante
PUT /restaurante/{id} - Atualiza restaurante existente
DELETE /restaurante/{id} - Deleta restaurante por ID
Produtos
GET /produtos - Lista todos os produtos
GET /produtos/{id} - Busca produto por ID
POST /produtos - Cria um novo produto
PUT /produtos/{id} - Atualiza produto existente
DELETE /produtos/{id} - Deleta produto por ID
Pedidos
GET /pedido - Lista todos os pedidos
GET /pedido/{id} - Busca pedido por ID
POST /pedido - Cria um novo pedido
PUT /pedido/{id} - Atualiza pedido existente
DELETE /pedido/{id} - Deleta pedido por ID
Configuração do Banco de Dados (MySQL no Docker)
properties

Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/meubanco?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Como Rodar a Aplicação
Certifique-se que o Docker está rodando e o container MySQL está ativo, com o banco meubanco.
Compile o projeto com Maven:

Copy code
mvn clean install
Rode a aplicação:

Copy code
mvn spring-boot:run
Acesse a API em:

Copy code
http://localhost:8080
Funcionalidades
CRUD completo para Restaurantes, Produtos e Pedidos
Validação das entidades
Associação entre Restaurante, Produto e Pedido





