# 🏰 Medieval World API

Bem-vindo ao **Medieval World**, uma API RESTful feita com **Spring Boot** para gerenciar personagens, itens e suas interações em um universo medieval.

> Autor: **Leandro Correia**

---

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (foco em testes)
- Lombok
- Hibernate Validator

---

## 🔧 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/correialeo/medieval-world.git
cd medieval-world

Rode o projeto com sua IDE preferida ou com Maven:

./mvnw spring-boot:run

Acesse a interface H2 em:

http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:medieval-world
```

## 🧱 Modelos principais
🔹 Personagem
```json

    {
      "id": 1,
      "nome": "Arthas",
      "classe": "GUERREIRO",
      "nivel": 10,
      "moedas": 150.00
    },
```
🔹 Item
```json
    {
      "id": 21,
      "nome": "Espada das Ruínas de Osasco",
      "type": "ARMA",
      "rarity": "LENDARIO",
      "price": 999999.00,
      "owner": {
        "id": 2,
        "nome": "Merlin",
        "classe": "MAGO",
        "nivel": 12,
        "moedas": 200.00
      }
    }
```
# 📮 Endpoints disponíveis

## 🔹 Personagens

| Método | Endpoint       | Descrição                     |
|--------|----------------|--------------------------------|
| GET    | `/api/personagem` | Listar todos os personagens (filtros opcionais)   |
| GET    | `/api/personagem/{id}` | Retorna um personagem   |
| POST   | `/api/personagem` | Criar um personagem           |
| PUT   | `/api/personagem` | Altera um personagem           |
| DELETE   | `/api/personagem` | Apagar um personagem           |

### Parâmetros de filtro (query params):

- `nome` (opcional)
- `classe` (opcional) - Ex: `GUERREIRO`, `MAGO`, `ARQUEIRO`

## 🔹 Itens

| Método | Endpoint          | Descrição                     |
|--------|-------------------|--------------------------------|
| GET    | `/api/item`          | Listar todos os itens (filtros opcionais)         |
| GET    | `/api/item/{id}` | Retorna um item   |
| POST   | `/api/item`          | Criar um item                 |
| PUT   | `/api/item`          | Altera um item                 |
| DELETE   | `/api/item`          | Apagar um item                 |

### Parâmetros de filtro (query params):

- `nome` (opcional)
- `raridade` (opcional) - Ex: `COMUM`, `RARO`, `EPICO`, `LENDARIO`
- `tipo` (opcional) - Ex: `ARMA`, `ARMADURA`, `POCAO`, `ACESSORIO`
- `precoMin` (opcional) - decimal
- `precoMax` (opcional) - decimal

---

# 🧪 Exemplos de requisições

### ✅ Criar personagem

✅ Criar personagem

```json
{
  "nome": "Valdemir",
  "classe": "GUERREIRO",
  "nivel": 99,
  "moedas": 5000.75
}
```

✅ Criar item

```json
{
  "nome": "Espada das Ruínas de Osasco",
  "type": "ARMA",
  "rarity": "LENDARIO",
  "price": 999999,
  "owner": {
    "id": 2
  }
}
```
🔍 Filtrar itens <br>
GET /api/item?raridade=EPICO&nome=esp (Espada de raridade épica)

## 🌱 Seeder automático
O projeto conta com um DatabaseSeeder que popula o banco H2 com:

- 5 personagens com classes variadas
- 20 itens aleatórios com diferentes raridades, poderes e donos

Isso facilita os testes durante o desenvolvimento.

## 👤 Autor
Leandro Correia

Projeto desenvolvido para fins acadêmicos e de prática com Spring Boot.

