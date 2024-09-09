# Desafio Backend
Confira o enunciado completo, [clique aqui](https://github.com/hsmiranda/Teste-Desenv-FullStack)

## Requisitos funcionais
1. Cadastrar/atualizar e deletar um veículo;
2. Consultar um veículo especifico por id / consultar veículos por query string;
3. Retorna todos os veículos;

## Solução Técnica
1. A API deverá ser Restfull em Java, utilizando os frameworks (Quarkus ou Spring) com os métodos (GET, POST, PUT, DELETE).
3. O banco de dados precisa ser um desses dois: (MySQL, PostgresSQL).

## Regras de negócios
- RN001 - Não pode haver veiculos com o mesmo numero de chassi.
- RN002 - O sistema não deve permite preços negativos.
- RN003 - O sistema não deve permitir que veiculos tenham no cadastro ou atualização, ano supeior ao corrente, por exemplo: o ano atual é 2023 e um veiculo estão tentando cadastrar com o ano 2024.
- RN004 - A busca deverá exibir até no máximo 10 resultados por vez.
- RN005 - O sistema deve ser seguro, não permitindo que códigos maliciosos sejam inseridos no meio dos textos.

## Tecnologias utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- Lombok
- Postgres
- Docker
- Flyway

## Chamadas
#### URL chamada GET (Busca todos os veículos)
http://localhost:8081/veiculos

#### URL chamada GET (Busca veículo por id)
http://localhost:8081/veiculos/id

#### URL chamada GET (Busca por query string)
http://localhost:8081/veiculos/filtro?[query_strings])

#### URL chamada POST (Salvar um veículo)
http://localhost:8081/veiculos
```json
{
  "veiculo": "Onix",
  "marca": "Chevrolet",
  "ano": 2021,
  "descricao": "Carro popular, ideal para a cidade.",
  "vendido": true,
  "chassi": "2B3C4D5E6F7G8H9I0J1KF",
  "preco": 55000
}
```
#### URL chamada PUT (Atualizar um veículo)
http://localhost:8081/veiculos/id
```json
{
  "veiculo": "Onix",
  "marca": "Chevrolet",
  "ano": 2020,
  "descricao": "Carro popular, ideal para a cidade.",
  "vendido": false,
  "chassi": "2B3C4D5E6F7G8H9I0J1KF",
  "preco": 54000
}
```

#### URL chamada DELETE (Deletar um veículo)
http://localhost:8081/veiculos/id







