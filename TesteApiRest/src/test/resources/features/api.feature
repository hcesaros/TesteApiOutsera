#language: pt

#Autor: Henrique Cesar
#Data: 05/05/2025

Funcionalidade: Testes de API com Rest Assured e Cucumber

  @Teste01
  Cenario: Requisição GET bem-sucedida
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200

  @Teste02 @BuscaPost @BuscaPostInexistente
  Esquema do Cenário: Buscar post por ID
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/<postId>"
    Então o código de status da resposta deve ser <statusCode>
    E o corpo da resposta deve conter o campo "<campoEsperado>"

    Exemplos:
      | postId | statusCode | campoEsperado |
      | 1      | 200        | userId        |
      | 9999   | 404        |               |

  @Teste03
  Cenario: Criar novo post
    Dado que a API está disponível
    Quando eu envio uma requisição POST para o endpoint "/posts" com o corpo:
      | title           | body                        | userId |
      | Teste Cucumber  | Conteúdo gerado por testes  | 1      |
    Entao o código de status da resposta deve ser 201
    E o corpo da resposta deve conter o campo "title"

  @Teste04
  Cenario: Atualizar post existente
    Dado que a API está disponível
    Quando eu envio uma requisição PUT para o endpoint "/posts/1" com o corpo:
      | id | title            | body               | userId |
      | 1  | Título atualizado | Conteúdo atualizado | 1      |
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "title"

  @Teste05
  Cenario: Deletar post existente
    Dado que a API está disponível
    Quando eu envio uma requisição DELETE para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200

  @Teste06
  Cenario: Buscar lista de usuários
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/users"
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "username"
