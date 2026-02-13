package test.automation.APITests;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;

public class APIBaseTest {
    Faker faker;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com";
        RestAssured.defaultParser = Parser.JSON;
        faker = new Faker();
    }
}
