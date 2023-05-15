package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ClickStrategy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;

@DefaultUrl("http://www.demoblaze.com/index.html")
public class DemoBlazePage extends PageObject {
    @FindBy(id = "login2")
    private WebElementFacade loginButton;
    @FindBy(id = "loginusername")
    private WebElementFacade loginUsernameTextBox;
    @FindBy(id = "loginpassword")
    private WebElementFacade loginPasswordTextBox;
    @FindBy(className = "btn-primary")
    private WebElementFacade loginSubmitButton;

    public void pressLoginButton() {
        WebElementFacade loginButton = find(By.id("login2"));
        loginButton.click();
    }

    public void addUsernameAndPassword(String username, String password) {
        WebElementFacade loginUsernameTextBox = find(By.id("loginusername"));
        WebElementFacade loginPasswordTextBox = find(By.id("loginpassword"));
        loginUsernameTextBox.type(username);
        loginPasswordTextBox.type(password);
    }

    public void pressSubmitButton() {
        WebElementFacade submitButton = find(By.className("btn-primary"));
        submitButton.click();
    }


    public void pressLogout() {
        WebElementFacade logoutButton = find(By.id("logout2"));
        logoutButton.click();
    }

    public void clickOnProduct() {
        WebElementFacade productAnchor = find(By.linkText("Samsung galaxy s6"));
        productAnchor.click();
    }
}
