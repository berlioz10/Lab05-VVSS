package org.example.features.useCaseFlow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.example.steps.serenity.FirstSteps;
import org.example.steps.serenity.ProductSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SerenityRunner.class)
public class UseCaseTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public FirstSteps loginSteps;

    @Steps
    public ProductSteps productSteps;

    @Issue("#Use-case-test")
    @Test
    public void use_case_test() throws FileNotFoundException {

        JsonElement jsonElement = JsonParser.parseReader(new FileReader("src/test/resources/test.json"));

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();

        loginSteps.pressLogin();
        loginSteps.addUsernameAndPassword(username, password);
        loginSteps.pressLoginSubmit();
//        loginSteps.should_see_logout();

        productSteps.clickOnProduct();
//        productSteps.should_see_add_to_cart();

        productSteps.pressAddToCart();
        Alert alert = ExpectedConditions.alertIsPresent().apply(webdriver);
        assertNotEquals(null, alert);
//        assertEquals("Product added", alert.getText());
        alert.accept();

        loginSteps.pressLogout();
        loginSteps.pressLogin();
//        loginSteps.should_see_login();
//        loginSteps.should_not_see_add_to_cart();
    }
}
