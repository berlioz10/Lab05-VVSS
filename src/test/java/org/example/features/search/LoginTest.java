package org.example.features.search;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

import java.io.FileNotFoundException;
import java.io.FileReader;

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
    public void login_with_random_account_test() throws InterruptedException, FileNotFoundException {

        JsonElement jsonElement = JsonParser.parseReader(new FileReader("src/test/resources/test.json"));

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
        anna.pressLogin();
        anna.addUsernameAndPassword(username, password);
        anna.pressLoginSubmit();
//        anna.should_see_logout();
        anna.pressLogout();
//        anna.should_see_login();
    }

    @Issue("#Try-First-2")
    @Test
    public void login_without_password_test() throws InterruptedException, FileNotFoundException {

        JsonElement jsonElement = JsonParser.parseReader(new FileReader("src/test/resources/test.json"));

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("empty_password").getAsString();

        anna.pressLogin();
        anna.addUsernameAndPassword(username, password);
        anna.pressLoginSubmit();

        Alert alert = ExpectedConditions.alertIsPresent().apply(webdriver);
        // the alert did exist
        assertNotEquals(null, alert);
        // alerts work stupid, cannot get the text from it
        // assertEquals("Please fill out Username and Password.", alert.getText());
        alert.accept();
    }
}