# DSCatalog

API REST para gerenciamento de catálogo de produtos e categorias, desenvolvida em Java com Spring Boot, aplicando arquitetura em camadas (Controller, Service, Repository, DTO).

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- Spring Web
- Spring Security
- Bean Validation
- H2 Database (ambiente de desenvolvimento)
- PostgreSQL (ambiente de produção)
- Maven

## Funcionalidades

- CRUD completo de **Produtos** (`/products`)
- CRUD completo de **Categorias** (`/categories`)
- Listagem paginada de produtos e categorias
- Validação de dados de entrada com Bean Validation
- Console H2 disponível em ambiente de desenvolvimento para inspeção do banco de dados

## Endpoints principais

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/products` | Lista produtos (paginado) |
| GET | `/products/{id}` | Busca produto por ID |
| POST | `/products` | Cria um novo produto |
| PUT | `/products/{id}` | Atualiza um produto existente |
| DELETE | `/products/{id}` | Remove um produto |
| GET | `/categories` | Lista categorias (paginado) |
| GET | `/categories/{id}` | Busca categoria por ID |
| POST | `/categories` | Cria uma nova categoria |
| PUT | `/categories/{id}` | Atualiza uma categoria existente |
| DELETE | `/categories/{id}` | Remove uma categoria |

## Como executar o projeto

### Pré-requisitos
- Java 21 instalado
- Maven instalado

### Passos

```bash
git clone https://github.com/rodrigoalb/DSCatalog.git
cd DSCatalog/backend
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

O console do banco H2 pode ser acessado em `http://localhost:8080/h2-console` (ambiente de desenvolvimento).

## Estrutura do projeto

O projeto segue a arquitetura em camadas:
- **Controller**: exposição dos endpoints REST (`ProductController`, `CategoryController`)
- **Service**: regras de negócio
- **Repository**: acesso a dados via Spring Data JPA
- **DTO**: objetos de transferência de dados entre as camadas

## Autor

Rodrigo Barbosa
[LinkedIn](https://www.linkedin.com/in/rodrigo-alba/)
