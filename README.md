# ☕ Java CRUD com DAO, JDBC e Arquitetura em Camadas

> Projeto educacional focado na criação do CRUD com boas práticas de arquitetura de software em Java.

---

## 📌 Sobre o Projeto

Este projeto consiste no desenvolvimento de um sistema CRUD (**Create, Read, Update, Delete**) em Java com o objetivo de consolidar conhecimentos em:

- Orientada a Objetos (POO)
- JDBC
- Padrão DAO (Data Access Object)
- Arquitetura em Camadas
- Separação de responsabilidades
- Modelagem de dados
- Boas práticas de organização de código

Mais do que apenas salvar dados em um banco, o foco também foi aprender **como estruturar um sistema de forma escalável e manutenível**, aproximando-se da arquitetura utilizada em aplicações profissionais.

O sistema utiliza **PostgreSQL** como banco de dados e implementa uma separação clara entre domínio, acesso a dados e infraestrutura.

---

## 🧠 Objetivo Educacional

O projeto foi desenvolvido para entender na prática conceitos fundamentais do CRUD e da engenharia de software.

---

## 📊 Diagrama de Classe

![[CRUD JDBC DAO.png]]

---

## 📂 Estrutura do Projeto

src/  
 ├── entidades/  
 │    ├── Vendedor.java  
 │    └── Departamento.java  
 │  
 ├── dao/  
 │    ├── VendedorDAO.java  
 │    ├── DepartamentoDAO.java  
 │    └── FabricaDao.java  
 │  
 ├── dao/implementacao/  
 │    ├── VendedorDAOJDBC.java  
 │    └── DepartamentoDAOJDBC.java  
 │  
 ├── bancodedados/  
 │    ├── ConexaoBancoDeDados.java  
 │    └── BdException.java  
 │  
 └── servicos/notificacao/  
      └── NotificacaoBancoDeDados.java  

---

## 🧩 Entidades

Representam objetos do mundo real e não possuem dependência com o banco de dados.

- `Vendedor`
- `Departamento`

> O banco conhece as tabelas  
> O sistema conhece objetos

---

## 📚 DAO

Define **o que pode ser feito**, mas não como.

Exemplo de operações:

- Inserir
- Atualizar
- Deletar
- Buscar por ID
- Listar

Isso permite trocar o banco sem alterar a aplicação.

---

## 🔌 Implementação JDBC

Camada responsável por executar SQL.


Objeto Java → SQL → Banco

---

## 🏭 Factory Pattern

A classe `FabricaDao` decide qual implementação concreta será usada.

A aplicação nunca instancia diretamente:

new VendedorDAOJDBC()

Ela apenas solicita:

FabricaDao.criarVendedorDAO()

Isso permite trocar o tipo de persistência futuramente.

---

## 💉 Injeção de Dependência

Os objetos recebem suas dependências ao invés de criá-las.

Isso reduz acoplamento e permite testes.

---

## ⚙️ Infraestrutura

Centraliza recursos técnicos do sistema:

- Gerenciamento de conexão
- Tratamento de exceções
- Padronização de erros

---

## 📄 Configuração Externa

Arquivo `datasource.properties`:

user=postgres
password=senharoot
db.url=jdbc:postgresql://localhost:5432/cadastrovendedor
ssl=false

Permite alterar o banco sem recompilar o projeto.

---

## 🔔 Sistema de Notificação

Foi implementado um sistema simples de notificações para informar operações:

- Inserção realizada
- Atualização realizada
- Exclusão realizada
- Erros

Pensado para futuras expansões (logs, eventos, auditoria, etc).

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- JDBC
- PostgreSQL 17
- Programação Orientada a Objetos
- Arquitetura em Camadas

---

## 📚 Conceitos Aprendidos

- Data Access Layer (DAL)
- Factory Pattern
- Dependency Injection (DI)
- Inversion of Control (IoC)
- Externalização de Configuração
- Separação de responsabilidades
- Alguns princípios SOLID de forma manual, utilizando interfaces, fábrica de objetos e injeção de dependência mas sem uso de frameworks.

---

## 🎯 Conclusão

Este projeto demonstra que um CRUD pode ser simples de implementar, mas difícil de manter se não houver organização estrutural.

O principal aprendizado foi:

> Software profissional não é sobre fazer funcionar, é sobre continuar funcionando quando crescer.

---

## 🚀 Possíveis Melhorias Futuras

- Interface gráfica
- API REST
- Sistema de logs
- Testes automatizados

---

## 👨‍💻 Autor

Ilram Lima
Este projeto foi desenvolvido como parte do meu portfólio técnico

⭐ Se este projeto foi útil para seus estudos, considere deixar uma estrela!
Desenvolvido com ☕ e muito aprendizado