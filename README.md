# 💈 Barbearia - Service de Agendamento (API REST)

Uma API REST desenvolvida em **Java** com **Spring Boot** para gerenciamento de agendamentos de serviços em uma barbearia.

---

## 🛠️ Tecnologias Utilizadas

* **Java 25**
* **Spring Boot 4**
* **Spring Data JPA** (Persistência de dados)
* **H2 Database** (Banco de dados em memória)
* **Lombok** (Produtividade e redução de boilerplate)
* **Maven** (Gerenciamento de dependências)

---

## 📌 Funcionalidades Mapeadas

- [x] Cadastro de Clientes (`/api/clientes`)
- [x] Cadastro de Serviços (`/api/servicos`)
- [x] Criação de Agendamentos (`/api/agendamentos`)
- [x] Validação de regras de negócio (impedir horários retroativos e conflitos de agendamento)
- [x] Cancelamento de Agendamentos (`/api/agendamentos/{id}/cancelar`)

---

## 🛠️ Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/cadutk/agendamento-service.git](https://github.com/cadutk/agendamento-service.git)
