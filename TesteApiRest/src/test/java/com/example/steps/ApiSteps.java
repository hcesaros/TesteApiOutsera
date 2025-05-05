package com.example.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

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
    public void queAAPIEstáDisponível() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Envia uma requisição GET para o endpoint informado
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     */
    @Quando("eu envio uma requisição GET para o endpoint {string}")
    public void euEnvioUmaRequisiçãoGETParaOEndpoint(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    /**
     * Valida se o status code da resposta é igual ao esperado
     * @param statusCode Código esperado (ex: 200, 404)
     */
    @Entao("o código de status da resposta deve ser {int}")
    public void oCódigoDeStatusDaRespostaDeveSer(int statusCode) {
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
     * @param corpo JSON no formato string com os dados a serem enviados
     */
    @Quando("eu envio uma requisição POST para o endpoint {string} com o corpo:")
    public void euEnvioUmaRequisiçãoPOSTParaOEndpointComOCorpo(String endpoint, String corpo) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(corpo)
                .when()
                .post(endpoint);
    }

    /**
     * Envia uma requisição DELETE para remover um recurso
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     */
    @Quando("eu envio uma requisição DELETE para o endpoint {string}")
    public void euEnvioUmaRequisiçãoDELETEParaOEndpoint(String endpoint) {
        response = RestAssured.delete(endpoint);
    }

    /**
     * Envia uma requisição PUT com corpo JSON para atualizar um recurso
     * @param endpoint Caminho do recurso (ex: "/posts/1")
     * @param corpo JSON com os dados atualizados
     */
    @Quando("eu envio uma requisição PUT para o endpoint {string} com o corpo:")
    public void euEnvioUmaRequisiçãoPUTParaOEndpointComOCorpo(String endpoint, String corpo) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(corpo)
                .when()
                .put(endpoint);
    }
}
