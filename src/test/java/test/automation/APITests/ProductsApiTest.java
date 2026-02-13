package test.automation.APITests;

import org.testng.annotations.Test;
import test.automation.data.Constants;
import test.automation.services.ProductsService;
import test.automation.steps.APISteps.ProductsSteps;

public class ProductsApiTest extends APIBaseTest{
    private final ProductsSteps productsSteps =
            new ProductsSteps(new ProductsService());

    @Test(description = "API 1: Get All Products List")
    public void getAllProductsTest() {
        productsSteps.validateGetAllProducts();
    }

    @Test(description = "API 2: POST To All Products List")
    public void postProductsNegativeTest() {
        productsSteps.validatePostNotAllowed();
    }

    @Test(description = "API 3: Get All Brands List")
    public void getAllBrandsTest() {
        productsSteps.validateGetAllBrands();
    }

    @Test(description = "API 4: PUT To All Brands List")
    public void putBrandsNegativeTest() {
        productsSteps.validatePutBrandsNotAllowed();
    }

    @Test(description = "API 5: POST To Search Product")
    public void searchProductTest() {
        productsSteps.validateSearchProduct("tshirt");
    }

    @Test(description = "API 6: POST To Search Product without parameter")
    public void searchProductWithoutParameterTest() {
        productsSteps.validateSearchProductWithoutParameter();
    }

    @Test(description = "API 7: POST To Verify Login with valid details")
    public void verifyLoginTest() {
        productsSteps.validateVerifyLogin(Constants.SIGN_IN_EMAIL, Constants.SIGN_IN_PASSWORD);
    }

    @Test(description = "API 8: POST To Verify Login without email parameter")
    public void verifyLoginWithoutEmailTest() {
        productsSteps.validateVerifyLoginWithoutEmail("your_password");
    }

    @Test(description = "API 9: POST To Verify Login with invalid details")
    public void verifyLoginWithInvalidDetailsTest() {
        productsSteps.validateVerifyLoginWithInvalidDetails(
                faker.internet().emailAddress(),
                faker.internet().password()
        );
    }

    @Test(description = "API 10: GET User Detail by Email")
    public void getUserDetailByEmailTest() {

        productsSteps.validateGetUserDetailByEmail(Constants.SIGN_IN_EMAIL);
    }

}
