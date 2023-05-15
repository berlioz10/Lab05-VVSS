package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DemoBlazePage;
import org.example.pages.ProductPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertFalse(productPage.hasAddToCartButton());
    }
}
