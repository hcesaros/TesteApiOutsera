package com.example.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import io.cucumber.datatable.DataTable;

import java.util.Map;


/**
 * Classe que implementa os passos definidos nos arquivos .feature
 * Utiliza RestAssured para realizar chamadas HTTP e Cucumber para definir a BDD.
 */
public class ApiSteps {

    // Armazena a resposta da requisição para ser usada em validações
    private Response response;

    /**
     * Define a URL base da API simulada JSONPlaceholder
     */
    @Dado("que a API está disponível")
    public void queApiEstaDisponivel() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Envia uma requisição GET para o endpoint informado
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     */
    @Quando("eu envio uma requisição GET para o endpoint {string}")
    public void enviarRequisicaoGetParaEndpoint(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    /**
     * Valida se o status code da resposta é igual ao esperado
     * @param statusCode Código esperado (ex: 200, 404)
     */
    @Entao("o código de status da resposta deve ser {int}")
    public void oCodigoDeStatusDaRespostaDeveSer(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    /**
     * Verifica se o corpo da resposta contém um campo ou valor específico
     * @param campo Texto esperado dentro do corpo da resposta
     */
    @E("o corpo da resposta deve conter o campo {string}")
    public void oCorpoDaRespostaDeveConterOCampo(String campo) {
        assertThat(response.getBody().asString(), containsString(campo));
    }

    /**
     * Envia uma requisição POST com corpo em JSON para o endpoint informado
     * @param endpoint Caminho do recurso (ex: "/posts")
     * @param dataTable com os dados a serem enviados
     */
    @Quando("eu envio uma requisição POST para o endpoint {string} com o corpo:")
    public void enviarRequisicaoPostComDados(String endpoint, DataTable dataTable) {
        Map<String, String> dados = dataTable.asMaps().get(0);

        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"title\": \"").append(dados.get("title")).append("\",")
                .append("\"body\": \"").append(dados.get("body")).append("\",")
                .append("\"userId\": ").append(dados.get("userId"))
                .append("}");

        String payload = builder.toString();

        response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(endpoint);
    }

    /**
     * Envia uma requisição DELETE para remover um recurso
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     */
    @Quando("eu envio uma requisição DELETE para o endpoint {string}")
    public void enviarRequisicaoDeleteParaEndpoint(String endpoint) {
        response = RestAssured.delete(endpoint);
    }

    /**
     * Envia uma requisição PUT com corpo JSON para atualizar um recurso
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     * @param dataTable JSON com os dados atualizados
     */
    @Quando("eu envio uma requisição PUT para o endpoint {string} com o corpo:")
    public void envioRequisicaoPutComDataTable(String endpoint, DataTable dataTable) {
        Map<String, String> dados = dataTable.asMaps().get(0);

        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"id\": ").append(dados.get("id")).append(",")
                .append("\"title\": \"").append(dados.get("title")).append("\",")
                .append("\"body\": \"").append(dados.get("body")).append("\",")
                .append("\"userId\": ").append(dados.get("userId"))
                .append("}");

        String payload = builder.toString();

        response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put(endpoint);
    }
}
