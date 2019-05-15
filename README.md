# Desafio Hivecloud

Utilizando boas práticas de desenvolvimento no software, dado um arquivo JSON criar um sistema onde seja 
exibias opções de pratos com seus respectivos acompanhamentos, onde o usuário deverá montar um pedido 
contendo um ou mais pratos e seus respectivos acompanhamentos.

# Requisitos Mínimos:

## Backand
- Utilizar Java 8, spring e maven
## Frontend:
- Utilizar a última versão do angular

# Sobre a aplicação

Ferramenta | Descrição
 ------ | ------
 Java 1.8 | Desenvolvimento
 Spring | Framework API REST 
 postgres | Banco de dados 
 PostMan | Testar as requisições 
 Github | Versionamento 
 Swagger | Documentação de API 
 Angular | Frontend 
 Bootstrap | Frontend
 
 # Como utilizar
 
 ## Backend
 Para utilizar o backend será necessário clonar o projeto para máquina instalar as dependências do pom.xml
 (Spring, postgres e Swagger) e rodar em localhost.
 <pre>http://localhost:8080/</pre>
 
 ## Frontend
 Para o frontend será necessário criar um projeto angular com o nome cardápio
 <pre>ng new cardapio</pre>
 Pegar o código fonte dentro do projeto spring colocar no projeto cardapio do angular
 <pre>https://github.com/rubens73/hivecloud/tree/master/src/main/resources/angular/src</pre>
 e ir para o diretorio iniciar o servidor angular e acessar o fron pelo localhost
 <pre> cd cardapio
 ng serve --open
 http://localhost:4200/</pre>
 
  # Snapshots
  ## Tela listar
 ![](https://github.com/rubens73/hivecloud/blob/master/tela_listar.png)
  
  ## Documentação
  ![](https://github.com/rubens73/hivecloud/blob/master/documenta%C3%A7%C3%A3o.png)
  
 
### O que melhorar:
* A depender da necessidade usar um banco de dados NoSql para uma grande quantidade de registros
* Desenvolver com técinas de TDD e SOLID.
* Definir um padrão de nomenclatura.
* Usar o padrão de versionamento [git flow]
* Ferramentas de integração continua (Travis)
* [Trello] para divisão de tarefas e acompanhamento das tarefas.
* Ferramenta de monitoramento de código [SonarQube]

[aplicação]: <https://desafioapi.herokuapp.com/swagger-ui.html>
[git flow]: <https://danielkummer.github.io/git-flow-cheatsheet/index.pt_BR.html>
[SonarQube]: <https://www.sonarqube.org/>
[Trello]: <https://trello.com/>
