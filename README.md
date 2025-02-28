# MedVol API

MedVol API é uma aplicação desenvolvida em Java com Spring Boot para o gerenciamento de cadastro de médicos.

## 📌 Funcionalidades

- Criar, listar, atualizar e deletar médicos
- Buscar médicos por especialidade
- Validação de dados
- Autenticação atrevés de token JWT

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**

## 🚀 Como Executar

### 📌 Pré-requisitos

- Java 17+
- PostgreSQL
- Maven

### 🔧 Passos para rodar o projeto

1. Clone o repositório:

   ```sh
   git clone https://github.com/Berla1/medvol-api.git
   ```

2. Acesse a pasta do projeto:

   ```sh
   cd medvol-api
   ```

3. Configure o banco de dados PostgreSQL no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/medvol
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. Compile e execute o projeto:

   ```sh
   mvn spring-boot:run
   ```

5. A API estará disponível em:

   ```
   http://localhost:8080
   ```

## 📖 Endpoints

**Utilize ferramentas para gerenciar endpoints

### 📌 Criar um médico

**POST** `/medicos`

```json
{
  "nome": "Dr. João Silva",
  "especialidade": "Cardiologia",
  "crm": "123456"
}
```

### 📌 Listar médicos

**GET** `/medicos`

### 📌 Atualizar médico

**PUT** `/medicos/{id}`

### 📌 Deletar médico

**DELETE** `/medicos/{id}`

## 🛠️ Testando a API

Para testar os endpoints da API, você pode utilizar ferramentas como **Postman** ou **Insomnia**. Basta configurar as requisições HTTP e enviar os dados conforme os exemplos acima.


