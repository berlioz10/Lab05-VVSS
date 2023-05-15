package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DemoBlazePage;
import org.example.pages.ProductPage;

import static org.junit.Assert.*;

public class FirstSteps {
    DemoBlazePage demoBlazePage;
    ProductPage productPage;

    @Step
    public void pressLogin() {
        demoBlazePage.pressLoginButton();
    }

    @Step
    public void addUsernameAndPassword(String username, String password) {
        demoBlazePage.addUsernameAndPassword(username, password);
    }

    @Step
    public void pressLoginSubmit() {
        demoBlazePage.pressSubmitButton();
    }

    @Step
    public void pressLogout() {
        demoBlazePage.pressLogout();
    }

    @Step
    public void should_not_see_add_to_cart() {
        assertEquals(productPage.hasAddToCartButton(), false);
    }

    @Step
    public void should_see_logout() {
        assertEquals(demoBlazePage.hasLogout(), true);
    }

    @Step
    public void should_see_login() {
        assertEquals(demoBlazePage.hasLogin(), true);
    }

    @Step
    public void is_the_home_page() {
        demoBlazePage.open();
    }
}
