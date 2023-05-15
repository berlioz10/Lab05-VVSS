package org.example.features.useCaseFlow;

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
    public void use_case_test() {
        loginSteps.pressLogin();
        loginSteps.addUsernameAndPassword("123", "123");
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
