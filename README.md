# vinicius-missao-test-Software

Sistema de Cadastro — Especificação e Base
Linguagem: Java (Maven)
Persistência: arquivo único JSON (data/cadastro.json)
Colaboração: Git/GitHub
Diagramas: IDEF0/ICOM, UML Casos de Uso e UML Classe
________________________________________
1) Objetivo
   Criar um sistema de cadastro simples (ex.: clientes) com persistência em um único arquivo JSON e documentação inicial do processo e do modelo.
________________________________________
2) Requisitos Funcionais (RF)
   •	RF01 — Cadastrar entidade (Cliente): id, nome, email, telephone, senha.
3) Requisitos Não Funcionais (RNF)
   •	Persistência: Criar um arquivo para cada  usuario   criado em data/getnome.json.
   •	Formato: JSON (coleção de objetos).
   •	Biblioteca: Jackson (leitura/escrita).
   •	CLI: menu simples em console para demonstrar as operações.
________________________________________
4) IDEF0 / ICOM (pré-codificação)
   4.1 Visão A-0 (Contexto)
   A0: Gerenciar Cadastro de Clientes
   •	Entradas (I): Dados do cliente (nome, email, telephone, senha), Comandos do usuário (inserir)
   •	Mecanismos (M): Java 17+, Biblioteca Jackson, Sistema de arquivos, Console (CLI)
   •	Saídas (O): Arquivo getnome.json atualizado, Mensagens de sucesso/erro, Listagens
   Nota: ICOM = Inputs, Controls, Outputs, Mechanisms.
   4.2 Decomposição de A0
   A1: Receber Comando do Usuário
- I: Comando (CRUD)
- C: Opções do menu
- M: Console
- O: Ação selecionada
  A2: Validar Dados
- I: Dados do cliente
- C: Regras de validação
- M: Java
- O: Dados válidos/erros
  A3: Operar Persistência
- I: Dados válidos / id para busca/remoção
- C: Formato JSON, Estratégia (arquivo único)
- M: Jackson + FS
- O: cadastro.json atualizado / resultado de leitura
  A4: Exibir Resultado
- I: Resultado da operação
- C: Formatação da saída
- M: Console
- O: Mensagem ao usuário / lista
  Dica: Desenhe as caixas A1..A4 com as setas I/C/O/M seguindo a notação IDEF0.

![diagrama](img/diagrama%20terca.jpg)



![diagramauml](img/diagrmacasodeusoeditar%20-%20Copia.jpg)