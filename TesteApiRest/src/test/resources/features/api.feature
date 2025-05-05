#language: pt

#Autor: Henrique Cesar
#Data: 05/05/2025

Funcionalidade: Testes de API com Rest Assured e Cucumber

  @Teste01
  Cenario: Requisição GET bem-sucedida
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "userId"

  @Teste02
  Cenario: Buscar post existente
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "userId"

  @Teste03
  Cenario: Buscar post inexistente
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/posts/9999"
    Entao o código de status da resposta deve ser 404

  @Teste04
  Cenario: Criar novo post
    Dado que a API está disponível
    Quando eu envio uma requisição POST para o endpoint "/posts" com o corpo:
    """
      {
        "title": "Teste Cucumber",
        "body": "Conteúdo gerado por testes",
        "userId": 1
      }
      """
    Entao o código de status da resposta deve ser 201
    E o corpo da resposta deve conter o campo "title"

  @Teste05
  Cenario: Atualizar post existente
    Dado que a API está disponível
    Quando eu envio uma requisição PUT para o endpoint "/posts/1" com o corpo:
  """
    {
      "id": 1,
      "title": "Título atualizado",
      "body": "Conteúdo atualizado",
      "userId": 1
    }
    """
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "title"

  @Teste06
  Cenario: Deletar post existente
    Dado que a API está disponível
    Quando eu envio uma requisição DELETE para o endpoint "/posts/1"
    Entao o código de status da resposta deve ser 200

  @Teste07
  Cenario: Buscar lista de usuários
    Dado que a API está disponível
    Quando eu envio uma requisição GET para o endpoint "/users"
    Entao o código de status da resposta deve ser 200
    E o corpo da resposta deve conter o campo "username"


