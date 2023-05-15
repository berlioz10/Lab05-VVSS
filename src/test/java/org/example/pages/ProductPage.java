package org.example.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.demoblaze.com/prod.html?idp_=1")
public class ProductPage extends PageObject {
    public void pressAddToCartButton() {
        WebElementFacade addToCartButton = find(By.cssSelector(".btn.btn-success.btn-lg"));
        addToCartButton.click();
    }

    public boolean hasAddToCartButton() {
        WebElementFacade addToCartButton = find(By.cssSelector(".btn.btn-success.btn-lg"));
        return addToCartButton.isPresent();
    }
}
