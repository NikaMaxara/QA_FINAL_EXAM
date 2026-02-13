package test.automation.steps.APISteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;
import test.automation.data.models.response.BrandsResponse;
import test.automation.data.models.response.PostProductsResponse;
import test.automation.data.models.response.ProductsResponse;
import test.automation.data.models.response.SearchProductResponse;
import test.automation.services.ProductsService;

public class ProductsSteps {

    private final ProductsService productsService;

    public ProductsSteps(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Step("Get all products and validate response")
    public void validateGetAllProducts() {

        ProductsResponse response = productsService.getAllProducts();

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertFalse(response.getProducts().isEmpty());
    }

    @Step("POST to products list and validate 405 error")
    public void validatePostNotAllowed() {

        PostProductsResponse response = productsService.postProductsAsObject();

        Assert.assertEquals(response.getResponseCode(), 405);
        Assert.assertEquals(response.getMessage(),
                "This request method is not supported.");
    }

    @Step("Get all brands and validate response")
    public void validateGetAllBrands() {

        BrandsResponse response = productsService.getAllBrands();

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertFalse(response.getBrands().isEmpty());
    }

    @Step("PUT to brands list and validate 405 error")
    public void validatePutBrandsNotAllowed() {

        PostProductsResponse response = productsService.putBrands();

        Assert.assertEquals(response.getResponseCode(), 405);
        Assert.assertEquals(response.getMessage(),
                "This request method is not supported.");
    }

    @Step("Search product: {productName} and validate response")
    public void validateSearchProduct(String productName) {

        SearchProductResponse response =
                productsService.searchProduct(productName);

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertFalse(response.getProducts().isEmpty());
    }


    @Step("Search product without parameter and validate 400 error")
    public void validateSearchProductWithoutParameter() {

        PostProductsResponse response =
                productsService.searchProductWithoutParameter();

        Assert.assertEquals(response.getResponseCode(), 400);
        Assert.assertEquals(response.getMessage(),
                "Bad request, search_product parameter is missing in POST request.");
    }

    @Step("Verify login with valid email and password")
    public void validateVerifyLogin(String email, String password) {

        PostProductsResponse response =
                productsService.verifyLogin(email, password);

        Assert.assertEquals(response.getResponseCode(), 200);
        Assert.assertEquals(response.getMessage(), "User exists!");
    }

    @Step("Verify login without email parameter")
    public void validateVerifyLoginWithoutEmail(String password) {

        PostProductsResponse response =
                productsService.verifyLoginWithoutEmail(password);

        Assert.assertEquals(response.getResponseCode(), 400);
        Assert.assertEquals(response.getMessage(),
                "Bad request, email or password parameter is missing in POST request.");
    }

    @Step("Verify DELETE method is not supported for verifyLogin API")
    public void validateDeleteVerifyLogin() {

        PostProductsResponse response =
                productsService.deleteVerifyLogin();

        Assert.assertEquals(response.getResponseCode(), 405);
        Assert.assertEquals(response.getMessage(),
                "This request method is not supported.");
    }

    @Step("Verify login with invalid credentials")
    public void validateVerifyLoginWithInvalidDetails(String email, String password) {

        PostProductsResponse response =
                productsService.verifyLoginWithInvalidDetails(email, password);

        Assert.assertEquals(response.getResponseCode(), 404);
        Assert.assertEquals(response.getMessage(), "User not found!");
    }


    @Step("Get user detail by email: {email}")
    public void validateGetUserDetailByEmail(String email) {
        Response response = productsService.getUserDetailByEmail(email);

        Assert.assertEquals(response.getStatusCode(), 200);

        String userEmail = response.jsonPath().getString("user.email");
        Assert.assertEquals(userEmail, email);

        String firstName = response.jsonPath().getString("user.first_name");
        String lastName = response.jsonPath().getString("user.last_name");

        System.out.println("User: " + firstName + " " + lastName + " (" + userEmail + ")");
    }



}
