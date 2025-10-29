# 🥷 NinjaAPI - Sistema de Gerenciamento de Ninjas

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> Uma API RESTful completa para cadastro, gerenciamento e controle de ninjas profissionais. Perfeita para academias ninja, clãs organizados e gestores de missões que precisam catalogar guerreiros silenciosos com habilidades únicas. 🐱‍👤

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias-utilizadas)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Configuração](#️-configuração)
- [Endpoints da API](#-endpoints-da-api)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Testes](#-testes)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Contato](#-contato)

---

## 🎯 Sobre o Projeto

A **NinjaAPI** foi desenvolvida para facilitar o gerenciamento completo de ninjas em organizações, clãs e academias. Com ela, você pode:

- Manter um registro organizado de todos os ninjas
- Filtrar por habilidades específicas, ranking e clã
- Acompanhar a evolução e missões completadas
- Gerenciar equipes e times de forma eficiente

Seja para treinar novos recrutas, gerenciar missões ou simplesmente manter um catálogo atualizado, esta API oferece todas as ferramentas necessárias.

---

## ✨ Funcionalidades

### Operações Básicas (CRUD)
- ✅ **Cadastro** de novos ninjas com informações detalhadas
- 🔍 **Consulta** por ID, nome, clã ou habilidades
- ✏️ **Atualização** de informações e progressão
- ❌ **Remoção** segura de ninjas do sistema

### Funcionalidades Avançadas
- 🎖️ **Sistema de Ranking** (D, C, B, A, S, SS)
- 🏯 **Organização por Clãs** e times
- 🎯 **Filtros Avançados** por múltiplos critérios
- 📊 **Estatísticas** e relatórios de ninjas
- 🔐 **Autenticação** e controle de acesso (em desenvolvimento)
- 📄 **Paginação** e ordenação de resultados

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17+** - Linguagem de programação
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **Spring Validation** - Validação de dados
- **Lombok** - Redução de boilerplate

### Banco de Dados
- **MySQL** - Produção
- **H2 Database** - Desenvolvimento e testes
- **Flyway/Liquibase** - Migrations (opcional)

### Documentação e Testes
- **Swagger/OpenAPI 3** - Documentação interativa da API
- **JUnit 5** - Testes unitários
- **Mockito** - Mocks para testes
- **Postman** - Testes de integração

### Ferramentas Auxiliares
- **Maven** - Gerenciamento de dependências
- **Docker** - Containerização (opcional)
- **Git** - Controle de versão

---

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- ☕ **Java JDK 17** ou superior
- 📦 **Maven 3.8+**
- 🐬 **MySQL 8.0+** (ou usar H2 em memória)
- 🔧 **Git**
- 📮 **Postman** (opcional, para testes)

---

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/ninja-api.git
cd ninja-api
```

### 2. Configure o banco de dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE ninja_db;
CREATE USER 'ninja_user'@'localhost' IDENTIFIED BY 'senha_segura';
GRANT ALL PRIVILEGES ON ninja_db.* TO 'ninja_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure as variáveis de ambiente

Edite o arquivo `src/main/resources/application.properties`:

```properties
# Configuração do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/ninja_db
spring.datasource.username=ninja_user
spring.datasource.password=senha_segura

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Porta da aplicação
server.port=8080
```

### 4. Compile e execute o projeto

```bash
# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## ⚙️ Configuração

### Usando H2 Database (Desenvolvimento)

Para ambiente de desenvolvimento, você pode usar H2:

```properties
# application-dev.properties
spring.datasource.url=jdbc:h2:mem:ninja_db
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Execute com: `mvn spring-boot:run -Dspring-boot.run.profiles=dev`

### Docker (Opcional)

```dockerfile
# Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

```bash
# Build e execução
docker build -t ninja-api .
docker run -p 8080:8080 ninja-api
```

---

## 📡 Endpoints da API

### Base URL
```
http://localhost:8080/api
```

### Documentação Swagger
```
http://localhost:8080/swagger-ui.html
```

### Endpoints Disponíveis

| Método | Rota | Descrição | Auth |
|--------|------|-----------|------|
| **GET** | `/ninjas/listar` | Lista todos os ninjas (paginado) | - |
| **GET** | `/ninjas/listar/{id}` | Busca ninja por ID | - |
| **GET** | `/ninjas/buscar?nome={nome}` | Busca ninja por nome | - |
| **GET** | `/ninjas/filtrar?cla={cla}&ranking={rank}` | Filtra por clã e ranking | - |
| **POST** | `/ninjas/criar` | Cadastra um novo ninja | 🔒 |
| **PUT** | `/ninjas/alterar/{id}` | Atualiza dados de um ninja | 🔒 |
| **PATCH** | `/ninjas/{id}/ranking` | Atualiza apenas o ranking | 🔒 |
| **DELETE** | `/ninjas/deletar/{id}` | Remove um ninja | 🔒 |
| **GET** | `/ninjas/estatisticas` | Retorna estatísticas gerais | - |
| **GET** | `/ninjas/cls/{cla}` | Lista ninjas de um clã | - |

### Parâmetros de Consulta (Query Params)

```
GET /ninjas/listar?page=0&size=10&sort=nome,asc
GET /ninjas/filtrar?ranking=S&cla=Dragão&habilidade=Espada
```

---

## 💡 Exemplos de Uso

### 1. Criar um Novo Ninja

**Request:**
```http
POST /api/ninjas/criar
Content-Type: application/json

{
  "nome": "Ryu Hayabusa",
  "cla": "Dragão",
  "ranking": "S",
  "idade": 28,
  "especialidade": "Combate Corpo a Corpo",
  "habilidades": [
    "Espada",
    "Agilidade Extrema",
    "Furtividade",
    "Ninjutsu Avançado"
  ],
  "missoesConcluidas": 147,
  "status": "ATIVO"
}
```

**Response:**
```json
{
  "id": 1,
  "nome": "Ryu Hayabusa",
  "cla": "Dragão",
  "ranking": "S",
  "idade": 28,
  "especialidade": "Combate Corpo a Corpo",
  "habilidades": [
    "Espada",
    "Agilidade Extrema",
    "Furtividade",
    "Ninjutsu Avançado"
  ],
  "missoesConcluidas": 147,
  "status": "ATIVO",
  "dataCadastro": "2025-10-28T10:30:00",
  "ultimaAtualizacao": "2025-10-28T10:30:00"
}
```

### 2. Buscar Ninja por ID

**Request:**
```http
GET /api/ninjas/listar/1
```

**Response:**
```json
{
  "id": 1,
  "nome": "Ryu Hayabusa",
  "cla": "Dragão",
  "ranking": "S",
  "habilidades": ["Espada", "Agilidade Extrema", "Furtividade"]
}
```

### 3. Atualizar Ranking

**Request:**
```http
PATCH /api/ninjas/1/ranking
Content-Type: application/json

{
  "ranking": "SS"
}
```

### 4. Filtrar Ninjas

**Request:**
```http
GET /api/ninjas/filtrar?ranking=S&cla=Dragão
```

### 5. Listar com Paginação

**Request:**
```http
GET /api/ninjas/listar?page=0&size=10&sort=nome,asc
```

**Response:**
```json
{
  "content": [...],
  "totalElements": 45,
  "totalPages": 5,
  "size": 10,
  "number": 0
}
```

---

## 📁 Estrutura do Projeto

```
ninja-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ninja/
│   │   │           ├── NinjaApiApplication.java
│   │   │           ├── controller/
│   │   │           │   └── NinjaController.java
│   │   │           ├── model/
│   │   │           │   ├── Ninja.java
│   │   │           │   ├── Ranking.java
│   │   │           │   └── Status.java
│   │   │           ├── repository/
│   │   │           │   └── NinjaRepository.java
│   │   │           ├── service/
│   │   │           │   ├── NinjaService.java
│   │   │           │   └── impl/
│   │   │           │       └── NinjaServiceImpl.java
│   │   │           ├── dto/
│   │   │           │   ├── NinjaRequestDTO.java
│   │   │           │   └── NinjaResponseDTO.java
│   │   │           ├── exception/
│   │   │           │   ├── NinjaNotFoundException.java
│   │   │           │   └── GlobalExceptionHandler.java
│   │   │           └── config/
│   │   │               ├── SwaggerConfig.java
│   │   │               └── SecurityConfig.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       └── application-prod.properties
│   └── test/
│       └── java/
│           └── com/
│               └── ninja/
│                   ├── controller/
│                   ├── service/
│                   └── repository/
├── .gitignore
├── pom.xml
├── README.md
└── LICENSE
```

---

## 🧪 Testes

### Executar todos os testes

```bash
mvn test
```

### Executar testes com cobertura

```bash
mvn clean test jacoco:report
```

O relatório será gerado em: `target/site/jacoco/index.html`

### Exemplo de Teste Unitário

```java
@Test
void deveCriarNinjaComSucesso() {
    NinjaRequestDTO request = new NinjaRequestDTO();
    request.setNome("Teste Ninja");
    request.setRanking("A");
    
    Ninja ninja = ninjaService.criar(request);
    
    assertNotNull(ninja.getId());
    assertEquals("Teste Ninja", ninja.getNome());
}
```

## 📄 Licença

Este projeto foi desenvolvido para fins de apredizado sobre APIs.

---


⭐ **Se este projeto foi útil, considere dar uma estrela!** ⭐
