# 🥷 NinjaAPI - Cadastro de Ninjas 

Bem-vindo à **NinjaAPI**, uma API RESTful voltada para o cadastro e gerenciamento de **ninjas**! Ideal para quem busca treinar, contratar ou apenas catalogar guerreiros silenciosos com habilidades únicas. 🐱‍👤

----

## 🚀 Funcionalidades

- ✅ Cadastro de novos ninjas
- 🔍 Consulta de ninjas por ID ou nome
- ✏️ Atualização de informações
- ❌ Remoção de ninjas
- 🧠 Filtros por ranking, clã, nível de habilidade, etc.

----

## 🧪 Tecnologias Utilizadas

- **Linguagem:** Java
- **Framework:** Spring Boot 
- **Banco de Dados:** MySQL / H2 / 
- **Ferramentas:** Postman, Swagger

----

## 📦 Endpoints (exemplos)

| Método | Rota              | Descrição                 |
|--------|-------------------|---------------------------|
| GET    | `/ninjas/listar`          | Lista todos os ninjas     |
| GET    | `/ninjas/listar/{id}`     | Busca ninja por ID        |
| POST   | `/ninjas/criar`           | Cadastra um novo ninja    |
| PUT    | `/ninjas/alterar/{id}`    | Atualiza um ninja         |
| DELETE | `/ninjas/deletar/{id}`    | Remove um ninja           |

----

## 🖼️ Exemplo de Requisição

```json
POST /ninjas
{
  "nome": "Ryu Hayabusa",
  "clã": "Dragão",
  "ranking": "S",
  "habilidades": ["Espada", "Agilidade", "Furtividade"]
}

