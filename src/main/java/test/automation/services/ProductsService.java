//package test.automation.services;
//
//import test.automation.data.Constants;
//import test.automation.data.models.response.BrandsResponse;
//import test.automation.data.models.response.ProductsResponse;
//import test.automation.data.models.response.PostProductsResponse;
//import io.restassured.response.Response;
//import test.automation.data.models.response.SearchProductResponse;
//
//import static io.restassured.RestAssured.given;
//
//public class ProductsService {
//
//    public ProductsResponse getAllProducts() {
//        return given()
//                .when()
//                .get(Constants.PRODUCTS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(ProductsResponse.class);
//    }
//
//    public Response postProducts() {
//        return given()
//                .when()
//                .post(Constants.PRODUCTS_ENDPOINT)
//                .then()
//                .extract()
//                .response();
//    }
//
//    public PostProductsResponse postProductsAsObject() {
//        return given()
//                .when()
//                .post(Constants.PRODUCTS_ENDPOINT)
//                .then()
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public BrandsResponse getAllBrands() {
//        return given()
//                .when()
//                .get(Constants.BRANDS_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(BrandsResponse.class);
//    }
//
//    public PostProductsResponse putBrands() {
//        return given()
//                .when()
//                .put(Constants.BRANDS_ENDPOINT)
//                .then()
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public SearchProductResponse searchProduct(String productName) {
//        return given()
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("search_product", productName)
//                .when()
//                .post(Constants.SEARCH_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(SearchProductResponse.class);
//    }
//
//    public PostProductsResponse searchProductWithoutParameter() {
//        return given()
//                .contentType("application/x-www-form-urlencoded")
//                .when()
//                .post(Constants.SEARCH_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public PostProductsResponse verifyLogin(String email, String password) {
//        return given()
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("email", email)
//                .formParam("password", password)
//                .when()
//                .post(Constants.VERIFY_LOGIN_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public PostProductsResponse verifyLoginWithoutEmail(String password) {
//        return given()
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("password", password)
//                .when()
//                .post(Constants.VERIFY_LOGIN_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public PostProductsResponse deleteVerifyLogin() {
//        return given()
//                .when()
//                .delete(Constants.VERIFY_LOGIN_ENDPOINT)
//                .then()
//                .statusCode(405)
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//    public PostProductsResponse verifyLoginWithInvalidDetails(String email, String password) {
//        return given()
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("email", email)
//                .formParam("password", password)
//                .when()
//                .post(Constants.VERIFY_LOGIN_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(PostProductsResponse.class);
//    }
//
//
//    public Response getUserDetailByEmail(String email) {
//        return given()
//                .queryParam("email", email)
//                .when()
//                .get(Constants.GET_USER_DETAIL_BY_EMAIL_ENDPOINT)
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//    }
//
//}
package test.automation.services;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import test.automation.data.Constants;
import test.automation.data.models.response.BrandsResponse;
import test.automation.data.models.response.PostProductsResponse;
import test.automation.data.models.response.ProductsResponse;
import test.automation.data.models.response.SearchProductResponse;

import static io.restassured.RestAssured.given;

public class ProductsService {

    private void attachRequest(String title, String request) {
        Allure.addAttachment(title, request);
    }

    private void attachResponse(String response) {
        Allure.addAttachment("Response Body", "application/json", response);
    }

    private void attachStatusCode(int statusCode) {
        Allure.addAttachment("Status Code", String.valueOf(statusCode));
    }

    public ProductsResponse getAllProducts() {

        attachRequest("Request URL", "GET " + Constants.PRODUCTS_ENDPOINT);

        Response response =
                given()
                        .when()
                        .get(Constants.PRODUCTS_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(ProductsResponse.class);
    }

    public Response postProducts() {

        attachRequest("Request URL", "POST " + Constants.PRODUCTS_ENDPOINT);

        Response response =
                given()
                        .when()
                        .post(Constants.PRODUCTS_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response;
    }

    public PostProductsResponse postProductsAsObject() {

        attachRequest("Request URL", "POST " + Constants.PRODUCTS_ENDPOINT);

        Response response =
                given()
                        .when()
                        .post(Constants.PRODUCTS_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public BrandsResponse getAllBrands() {

        attachRequest("Request URL", "GET " + Constants.BRANDS_ENDPOINT);

        Response response =
                given()
                        .when()
                        .get(Constants.BRANDS_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(BrandsResponse.class);
    }

    public PostProductsResponse putBrands() {

        attachRequest("Request URL", "PUT " + Constants.BRANDS_ENDPOINT);

        Response response =
                given()
                        .when()
                        .put(Constants.BRANDS_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public SearchProductResponse searchProduct(String productName) {

        attachRequest("Request",
                "POST " + Constants.SEARCH_ENDPOINT +
                        "\nsearch_product=" + productName);

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("search_product", productName)
                        .when()
                        .post(Constants.SEARCH_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(SearchProductResponse.class);
    }

    public PostProductsResponse searchProductWithoutParameter() {

        attachRequest("Request", "POST " + Constants.SEARCH_ENDPOINT);

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .when()
                        .post(Constants.SEARCH_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public PostProductsResponse verifyLogin(String email, String password) {

        attachRequest("Request",
                "POST " + Constants.VERIFY_LOGIN_ENDPOINT +
                        "\nemail=" + email +
                        "\npassword=" + password);

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("email", email)
                        .formParam("password", password)
                        .when()
                        .post(Constants.VERIFY_LOGIN_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public PostProductsResponse verifyLoginWithoutEmail(String password) {

        attachRequest("Request",
                "POST " + Constants.VERIFY_LOGIN_ENDPOINT +
                        "\npassword=" + password);

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("password", password)
                        .when()
                        .post(Constants.VERIFY_LOGIN_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public PostProductsResponse deleteVerifyLogin() {

        attachRequest("Request URL", "DELETE " + Constants.VERIFY_LOGIN_ENDPOINT);

        Response response =
                given()
                        .when()
                        .delete(Constants.VERIFY_LOGIN_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public PostProductsResponse verifyLoginWithInvalidDetails(String email, String password) {

        attachRequest("Request",
                "POST " + Constants.VERIFY_LOGIN_ENDPOINT +
                        "\nemail=" + email +
                        "\npassword=" + password);

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("email", email)
                        .formParam("password", password)
                        .when()
                        .post(Constants.VERIFY_LOGIN_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response.as(PostProductsResponse.class);
    }

    public Response getUserDetailByEmail(String email) {

        attachRequest("Request",
                "GET " + Constants.GET_USER_DETAIL_BY_EMAIL_ENDPOINT +
                        "\nemail=" + email);

        Response response =
                given()
                        .queryParam("email", email)
                        .when()
                        .get(Constants.GET_USER_DETAIL_BY_EMAIL_ENDPOINT)
                        .then()
                        .extract()
                        .response();

        attachStatusCode(response.getStatusCode());
        attachResponse(response.asPrettyString());

        return response;
    }
}
