package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasePage {
    protected <T> T setTextValue(SelenideElement element, String text, T instance) {
        element.clear();
        element.sendKeys(text);
        return instance;
    }

    protected void clickButton(SelenideElement button) {
        button.shouldBe(Condition.enabled).click();
    }
}
