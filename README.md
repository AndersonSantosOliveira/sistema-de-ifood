📋 Sobre
API RESTful para gerenciamento de restaurantes, produtos e pedidos de delivery.

🛠️ Tecnologias
Java 21
Spring Boot
Spring Data JPA / Hibernate
MySQL 8
Docker
Maven
📁 Estrutura

Copy code
src/main/java/br/com/adsuema/minifood/
├── controller/    # Endpoints REST
├── model/         # Entidades do banco
├── repository/    # Repositórios JPA
├── service/       # Regras de negócio
🌐 Endpoints
Restaurantes
Método

Endpoint

GET

/restaurante

GET

/restaurante/{id}

POST

/restaurante

PUT

/restaurante/{id}

DELETE

/restaurante/{id}

Produtos
Método

Endpoint

GET

/produtos

GET

/produtos/{id}

POST

/produtos

PUT

/produtos/{id}

DELETE

/produtos/{id}

Pedidos
Método

Endpoint

GET

/pedido

GET

/pedido/{id}

POST

/pedido

PUT

/pedido/{id}

DELETE

/pedido/{id}

⚙️ Configuração
Criar container MySQL:

bash

Copy code
docker run -d --name meu-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=meubanco mysql:8
Compilar e executar:

bash

Copy code
mvn clean install
mvn spring-boot:run
Aplicação disponível em: http://localhost:8080

✅ Funcionalidades
CRUD Restaurantes
CRUD Produtos
CRUD Pedidos
Associação entre entidades
Validação de dados




