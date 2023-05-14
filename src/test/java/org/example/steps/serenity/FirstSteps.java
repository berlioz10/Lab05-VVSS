package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DemoBlazePage;

public class FirstSteps {
    DemoBlazePage demoBlazePage;

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
}
