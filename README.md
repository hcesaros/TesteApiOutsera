# 🧪 Testes Automatizados de API com Cucumber, RestAssured e JUnit 5

Este projeto tem como objetivo a automação de testes de APIs REST utilizando **Cucumber**, **RestAssured** e **JUnit 5** com suporte a **publicação de relatórios no [reports.cucumber.io](https://reports.cucumber.io)**.

## ✅ Tecnologias utilizadas

- Java 11
- Maven
- Cucumber 7.x
- JUnit 5 (JUnit Platform Suite)
- RestAssured 5.x
- Relatórios:
  - HTML local (`target/cucumber-report.html`)
  - Publicação automática no [reports.cucumber.io](https://reports.cucumber.io)

---

## 📁 Estrutura do projeto

src
├── test
│ ├── java
│ │ └── com.example
│ │ ├── runners # Classe Runner com JUnit Platform
│ │ └── steps # Implementações das steps do Cucumber
│ └── resources
│ ├── features # Cenários de teste (BDD)
│ └── junit-platform.properties # Ativa a publicação no Cucumber Reports

---

## ▶️ Como executar os testes

### 1. Clonar o projeto

bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

### 2. Ativar publicação no Cucumber Reports (opcional)
export CUCUMBER_PUBLISH_ENABLED=true

### 3. Executar os testes
mvn clean test

---

📊 Relatórios de Teste
🔹 Relatório HTML local
Após a execução, o relatório estará disponível em:

target/cucumber-report.html

🔹 Publicação no Cucumber Reports
Se ativado, ao final da execução será exibido um link como este:

https://reports.cucumber.io/report-collections/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx

---

🧪 Exemplo de cenário (BDD)

Funcionalidade: Testes de API com Cucumber e publicação no Cucumber Reports

  Cenario: Verificar GET /posts/1
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "userId"

---    

💡 Possibilidades de expansão

Integração com CI/CD (GitHub Actions, Jenkins etc.);
Testes com autenticação/token;
Validação de schema JSON;
Execução paralela com tags e perfis.

---







