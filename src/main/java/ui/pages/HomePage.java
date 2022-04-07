package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private final SelenideElement homePageWrapper = $(".home-page");
    private final SelenideElement registerLink = homePageWrapper.$(By.linkText("Create account"));

    public HomePage() {
        homePageWrapper.should(Condition.exist);
    }

    @Step("Go to user registration page")
    public RegistrationPage goToRegistrationPage() {
        registerLink.click();
        return new RegistrationPage();
    }
}
