# Bootcamp Everis Site Reliability Engineer Essentials  :man_technologist:
<image src="https://github.com/P3d50/personapi/blob/main/assets/everisbootcamplogo.png" width="350" height="350" align="right">
 
## Sobre o bootcamp:  :seedling:  
   - Nessa jornada, através do bootcamp everis Site Reliability Engineer Essentials, são abordadas as principais ferramentas e práticas do mercado por grandes experts da área.
 
## Projeto final:  :deciduous_tree:
   - Construir do zero uma API REST com Spring Boot para cadastro e gerenciamento de pessoas de uma organização, até o <a href="http://everisdioapersonapi.herokuapp.com/swagger-ui/index.html"> Deploy na nuvem :cloud: (Heroku) </a>  <a href="https://github.com/P3d50/personapi/blob/main/src/main/resources/static/person-sample.json">request body JSON</a>
. Praticando os principais conceitos do estilo arquitetural REST envolvidos durante o desenvolvimento do projeto.
       - Setup inicial de projeto com o Spring Boot Initialzr 
       - Criação de modelo de dados para o mapeamento de entidades em bancos de dados
       - Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
       - Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.
       - Desenvolvimento de testes unitários para validação das funcionalidades
       - Implantação do sistema na <a href="http://everisdioapersonapi.herokuapp.com/swagger-ui/index.html">nuvem através do (Heroku) :cloud:</a>
       - <a href="https://github.com/P3d50/personapi/blob/main/src/main/resources/static/person-sample.json">Exemplo request body JSON</a>

       - ### Para fixar o aprendizado implementei a funcionalidade de busca por cpf (ex:/api/v1/people/cpf?num=111.111.111-11) criei testes unitários para a busca de CPF nas camadas repository, service e testes integrados para a camada de controller, utilizei JUnit5, AssertJ, e Diffblue. Criei testes para cobrir as demais funcionalidades. Configurei o Swagger para documentação da API.
	
![](https://github.com/P3d50/Santander-Bootcamp-Kotlin-Mobile-Developer-Digital-Innovation-One-2021/blob/main/TrabalhandoComAPIs/assets/api-screen-record.gif)

 
 # Bootcamp viabilizado em parceria com a <a href="https://digitalinnovation.one/">DIO</a> :handshake:
 
 <hr/>

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```


São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Conta no Heroku para o deploy do projeto na nuvem
* Muita vontade de aprender e compartilhar conhecimento :)

Abaixo, seguem links de conteúdos que me ajudaram no projeto:
* [Teste unitário de Respository](https://howtodoinjava.com/spring-boot2/testing/datajpatest-annotation/)
* [Software Testing Tutorial - Learn Unit Testing and Integration Testing](https://www.youtube.com/watch?v=Geq60OVyBPg&t=847s)
* [AssertJ - fluent assertions java library ](https://assertj.github.io/doc/#assertj-core/)
	

Abaixo, seguem links bem bacanas, sobre tópicos mencionados durante o bootcamp:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download)
* [Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Site oficial do Heroku](https://www.heroku.com/)
* [Site oficial do GIT](https://git-scm.com/)
* [Site oficial do GitHub](http://github.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)

[Neste link](https://drive.google.com/file/d/1crVPOVl6ok2HeYjh3fjQuGQn2lDZVHrn/view?usp=sharing), seguem os slides apresentados como o roteiro utilizado para o desenvolvimento do projeto.

