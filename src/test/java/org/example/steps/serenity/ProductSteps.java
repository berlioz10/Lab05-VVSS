package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DemoBlazePage;
import org.example.pages.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSteps {
    ProductPage productPage;

    DemoBlazePage demoBlazePage;

    @Step
    public void pressAddToCart() {
        productPage.pressAddToCartButton();
    }

    @Step
    public void clickOnProduct() {
        demoBlazePage.clickOnProduct();
    }

    @Step
    public void should_see_add_to_cart() {
        assertTrue(productPage.hasAddToCartButton());
    }
}
