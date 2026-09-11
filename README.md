# pattern-solid

Projeto acadêmico da disciplina de **Design Patterns**, com o objetivo de aplicar os
princípios **SOLID** no desenvolvimento de um sistema em Java que simula o
funcionamento de um **caixa eletrônico (ATM)**.

## 📋 Sobre o projeto

A proposta é construir uma simulação de caixa eletrônico utilizando boas práticas de
orientação a objetos, com foco especial na aplicação dos cinco princípios SOLID:

- **S** - Single Responsibility Principle (Princípio da Responsabilidade Única)
- **O** - Open/Closed Principle (Princípio Aberto/Fechado)
- **L** - Liskov Substitution Principle (Princípio da Substituição de Liskov)
- **I** - Interface Segregation Principle (Princípio da Segregação de Interface)
- **D** - Dependency Inversion Principle (Princípio da Inversão de Dependência)

O sistema deverá contemplar funcionalidades típicas de um caixa eletrônico, como
autenticação de usuário, consulta de saldo, saque, depósito e transferência,
estruturadas de forma que cada princípio SOLID seja evidenciado no design da solução.

## 🗓️ Datas importantes

| Marco | Data |
| --- | --- |
| Entrega do projeto | 01/10/2026 |
| Defesa de código | 08/10/2026 |

## 👥 Integrantes do grupo

- Alaertes Ribeiro dos Santos Jr
- Caio Azevedo
- Lorenzo Sorrentino Laskawski
- Vinicius Grzyb

## 🛠️ Tecnologias

- **Java** 23
- **Maven** (gerenciamento de dependências e build)

## 📁 Estrutura do projeto

```
pattern-solid/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── ProjetosJava/
                └── Main.java
```

## ▶️ Como executar

Pré-requisitos: JDK 23 e Maven instalados.

```bash
# Compilar o projeto
mvn compile

# Executar a classe principal
mvn exec:java -Dexec.mainClass="ProjetosJava.Main"
```
