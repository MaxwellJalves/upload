#Objetivo do projeto.

Projeto criado para ser um microserviço local para realizar upload de arquivos.

- Atualmente existem apenas dois recursos decursos disponivels. 

    - v1/upload/local : Responsável por salvar o arquivo em um diretorio local;
    - v1/upload/database : Responsável por salvar o arquivo no banco de dados;
  

- Nesse poc foi criado os passos utilizados para desenvolver esse recurso utilizando o Kanban do Git, tentando seguir o
conceito do git flow e realizando pequenos commits para cada etapada da criação .
 

>  https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow


## v2 Estudo --> utilização do Multipart/form-data

Criação de endpoint que espera receber um arquivo e 2 atributos de um formulario e retorna os dados mockado com os dados obtidos.
exemplo do formulário:

     <form
        encType="multipart/form-data"
        method="post"
        action="http://localhost:8083/v1/multipart">

        <label for="file">Arquivo</label>
        <input type="file" id="file" name="file"></input>

        <label for="nome">Nome</label>
        <input type="text" id="nome" name="nome"></input>

        <label for="protocolo">protocolo</label>
        <input type="text" id="protocolo" name="protocolo"></input>

        <input type="submit"></input>
      </form>


- no exemplo criado foi verificado que caso só passe o id do campos como nome do atributo esperado pela apis
  o back o atributo do input chegará como "NULL" para o back , e caso não tenha nenhuma tratativa irá retornar um
  status code 500 pois o servidor não estava preparado tratar o nullpointException.
 
- Após o mapeamento dos atributos realizado de forma correta o céu é o limite.