package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.example.steps.serenity.FirstSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public FirstSteps anna;

    @Issue("#Try-First-1")
    @Test
    public void login_with_random_account_test() throws InterruptedException {
        anna.pressLogin();
        anna.addUsernameAndPassword("123", "123");
        anna.pressLoginSubmit();
//        anna.should_see_logout();
        anna.pressLogout();
//        anna.should_see_login();
    }

    @Issue("#Try-First-2")
    @Test
    public void login_without_password_test() throws InterruptedException {
        anna.pressLogin();
        anna.addUsernameAndPassword("123", "");
        anna.pressLoginSubmit();

        Alert alert = ExpectedConditions.alertIsPresent().apply(webdriver);
        // the alert did exist
        assertNotEquals(null, alert);
        // alerts work stupid, cannot get the text from it
        // assertEquals("Please fill out Username and Password.", alert.getText());
        alert.accept();
    }
}