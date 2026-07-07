# API REST - Sistema de Reserva de Salas

## 📖 Sobre o projeto

Esta é uma API REST desenvolvida em Java com Spring Boot para gerenciar reservas de salas. O sistema permite cadastrar reservas, consultar reservas existentes e validar regras de negócio, como disponibilidade da sala e capacidade máxima.

O projeto foi desenvolvido com foco em boas práticas de desenvolvimento, utilizando arquitetura em camadas, JPA para persistência de dados e tratamento centralizado de exceções.

---

## 🚀 Tecnologias utilizadas

* Java 21 (ou a versão utilizada no projeto)
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

---

## 📁 Estrutura do projeto

```text
src
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── resources
```

Cada camada possui uma responsabilidade específica:

* **Controller:** recebe as requisições HTTP e retorna as respostas da API.
* **Service:** contém as regras de negócio.
* **Repository:** realiza o acesso ao banco de dados utilizando Spring Data JPA.
* **Entity:** representa as entidades persistidas no banco.
* **DTO:** objetos utilizados para comunicação entre cliente e API.
* **Exception:** tratamento padronizado de exceções.

---

## ⚙️ Funcionalidades

* Cadastro de reservas
* Listagem de reservas
* Verificação de conflito entre períodos
* Validação da capacidade máxima da sala
* Validação do status da sala
* Associação entre usuário, sala e reserva
* Tratamento padronizado de erros da API

---

## 📌 Regras de negócio

Uma reserva somente é criada quando:

* A sala existe.
* O usuário existe.
* A sala está ativa.
* A quantidade de pessoas não ultrapassa a capacidade máxima da sala.
* O período solicitado não conflita com outra reserva da mesma sala.

Caso alguma dessas regras seja violada, a API retorna um erro HTTP apropriado com uma mensagem descritiva.

---

## 📡 Endpoints

### Criar reserva

**POST**

```http
/reserva
```

Exemplo de requisição:

```json
{
  "usuarioId": 1,
  "salaId": 2,
  "inicio": "2026-07-06T08:00:00",
  "fim": "2026-07-06T10:00:00",
  "pessoas": 15
}
```

Resposta de sucesso:

```http
201 Created
```

---

### Listar reservas

**GET**

```http
/reserva/listar
```

Resposta:

```json
[
  {
    "id": 1,
    "salaId": 2,
    "inicio": "2026-07-06T08:00:00",
    "fim": "2026-07-06T10:00:00",
    "pessoas": 15
  }
]
```

---

## ❌ Tratamento de erros

A API utiliza tratamento centralizado de exceções, retornando respostas padronizadas.

Exemplo:

```json
{
  "status": 400,
  "mensagem": "Conflito de períodos",
  "campo": "periodo"
}
```

Principais códigos HTTP:

| Código | Descrição                                       |
| ------ | ----------------------------------------------- |
| 201    | Reserva criada com sucesso                      |
| 400    | Dados inválidos ou violação de regra de negócio |
| 404    | Usuário ou sala não encontrados                 |
| 500    | Erro interno do servidor                        |

---

## 🗄️ Modelo de domínio

O sistema é composto pelas seguintes entidades principais:

* Usuário
* Sala
* Reserva
* Período

Relacionamentos:

* Um usuário pode possuir várias reservas.
* Uma sala pode possuir várias reservas.
* Cada reserva pertence a um único usuário.
* Cada reserva pertence a uma única sala.
* Cada reserva possui um período (data/hora de início e fim).

---

## ▶️ Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/caua-hub/API-REST-Reserva-de-salas---JAVA---Spring.git
```

2. Acesse a pasta do projeto:

```bash
cd API-REST-Reserva-de-salas---JAVA---Spring
```

3. Configure as variáveis de ambiente ou o arquivo `application.properties` com as credenciais do banco de dados.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/reservas
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

4. Execute a aplicação:

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

## 💡 Melhorias futuras

* Autenticação com JWT
* Documentação automática com Swagger/OpenAPI
* Paginação nas consultas
* Filtros de busca por usuário, sala e período
* Testes unitários e de integração
* Docker para facilitar a execução da aplicação
* Controle de permissões por perfil de usuário

---

## 👨‍💻 Autor

Desenvolvido por **Cauã Naves** como projeto de estudos em Java, Spring Boot e desenvolvimento de APIs REST, com foco na aplicação de boas práticas de arquitetura, orientação a objetos e persistência de dados.
