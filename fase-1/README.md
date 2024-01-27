[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)

# Fase-1

## Rodando localmente

Clone o projeto
```bash
  $ git clone [https://link-para-o-projeto](https://github.com/flaviokovhub/tech-challenge.git)
```

Peças a serem executada via docker-compose
> 1 - backend jfood-api

> 2 - base de dados relacional postgreSQL
```bash
 services:
  backend:
    image: 'flaviokov/jfood-api:1.0'
    environment:
      - 'DB_URL=jdbc:postgresql://postgres:5432/jfood'
      - 'DB_PASS=jfood'
      - 'DB_USER=jfood'
    ports:
      - '8080:8080'
    depends_on:
      - postgres
  postgres:
    image: 'postgres:latest'
    environment:
      - 'POSTGRES_DB=jfood'
      - 'POSTGRES_PASSWORD=jfood'
      - 'POSTGRES_USER=jfood'
    ports:
      - '5432:5432'
  pgadmin:
    image: 'dpage/pgadmin4'
    ports:
      - "8888:80"
    environment:
      PGADMIN_DEFAULT_EMAIL: 'jfood@jfood.com'
      PGADMIN_DEFAULT_PASSWORD: 'jfood' 
```

Execute o docker-compose

Entre no diretório  tech-challenge/fase-1/jfood/ci

```bash
  $ cd ci/
```
Execute:
```bash
  $ docker-compose up
```

Acessando o Swagger:
> http://localhost:8080/swagger-ui/index.html#/

Endpoints:
![Alt text](fase-1/assets/swagger-ex.png "Endpoints")

Collections:
![Alt text](fase-1/assets/fase-1-Insomnia_2024-01-27 "Collections")
