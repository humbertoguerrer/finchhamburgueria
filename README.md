# Projeto para Finch Soluções

Este projeto foi desenvolvido para atender ao recrutamento da Finch Soluções.

## Objetivo

Implementar uma API REST que simula o sistema de vendas de uma hamburgueria, sendo que alguns lanches são fixos no cardápio e outros são montados de acordo com os
ingredientes que o cliente escolher.

## Tecnologias

- Java 8
- Spring Boot
- Hibernate e Spring Data JPA
- Spring Security
- MySQL
- IntelliJ IDEA
- Swagger
- Docker

## Visão Geral

São disponibilizados diversos endpoints para operações com clientes, pedidos, lanches e ingredientes.

## Instruções para inicialização

Com uma instância do `MySQL` aberta, basta baixar o o projeto projeto do Github e rodar a API finchhamburgueria. O banco de dados será populado com as informações básicas
de lanches e ingredientes através das informações lançadas no método main da aplicação (para desenvolvimento).

Opcionalmente, pode ser executado um script contido no diretório /db.

**A aplicação conta com implementação básica de segurança. Para acessar a aplicação via navegador deve ser fornecido o nome de usuário 'user' e a senha gerada no console
no momento de inicialização da aplicação. Para requisições via Postman o usuário e senha devem ser passados na aba 'Authorization'.**

A partir desse momento, o primeiro passo é instanciar um cliente através de uma requisição post no endpoint /clientes:

```
{
 "nome": "Gustavo",
 "cpf": "363.857.895-00"
}
```

Após é possível enviar a requisição de um pedido de lanche do cardápio ou novo:

Exemplo - lanches do cardápio:
```
{
 "clienteId": 1,
 "lanchesId": [
    2,
    3
  ]
}
```
Exemplos - lanches novos através de pedido:
```
{
   "clienteId": 1,
   "ingredientesId": [
       1,
       2,
       3
   ]
}
```
Exemplo - criação de novo lanche para o cardápio:

```
{
   "nome": "lancheABC",
           "ingredientes": [
       {
           "id": 3,
           "nome": "alface",
           "preco": 0.40

       },
       {
           "id": 5,
           "nome": "bacon",
           "preco": 2
       },
       {
           "id": 4,
           "nome": "ovo",
           "preco": 0.8
       }
   ]
}
```

Exemplo - atualização de novo lanche já existente:

```
{
   "id": 1,
   "nome": "lancheT",
           "ingredientes": [
       {
           "id": 3,
           "nome": "alface",
           "preco": 0.40

       },
       {
           "id": 5,
           "nome": "bacon",
           "preco": 2
       },
       {
           "id": 4,
           "nome": "ovo",
           "preco": 0.8
       }
   ]
}
```
Exemplo - inserção de novo ingrediente:

```
{
   "nome": "cebola",
   "preco": 0.5
}
```

Exemplo - atualização de ingrediente:

```
{
   "id": 2,
   "nome": "frango",
   "preco": 1.5
}
```
Docker disponibilizado pelo comando: docker pull humbertoguerrer/finchhamburgueria:latest

Todos os endpoints disponibilizados podem ser analisados através do endereço fornecido pelo Swagger: http://localhost:8080/swagger-ui/index.html

O que faltou/poderia ser melhorado com o tempo:
- Implementação de lógica de descontos que não foi implementada;
- Orquestração docker com instância automática de banco de dados;
- Valida de campos;
- Tratamento de exceções (não foi finalizado).
