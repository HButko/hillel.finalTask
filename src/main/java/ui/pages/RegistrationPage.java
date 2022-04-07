package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import utils.ui.data.User;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private final SelenideElement registerPageWrapper = $(".register-page");
    private final SelenideElement usernameInput = registerPageWrapper.$("input[formcontrolname='username']");
    private final SelenideElement nameInput = registerPageWrapper.$("input[formcontrolname='name']");
    private final SelenideElement lastnameInput = registerPageWrapper.$("input[formcontrolname='lastname']");
    private final SelenideElement passwordInput = registerPageWrapper.$("input[formcontrolname='password']");
    private final SelenideElement confirmPasswordInput = registerPageWrapper.$("input[formcontrolname='confirmPassword']");
    private final SelenideElement registerButton = registerPageWrapper.$("button");

    public RegistrationPage() {
        registerPageWrapper.shouldBe(Condition.exist);
    }

    @Step("Set username")
    public RegistrationPage setUsername(String username) {
        return setTextValue(usernameInput, username, this);
    }

    @Step("Set name")
    public RegistrationPage setName(String name) {
        return setTextValue(nameInput, name, this);
    }

    @Step("Set lastname")
    public RegistrationPage setLastname(String lastname) {
        return setTextValue(lastnameInput, lastname, this);
    }

    @Step("Set password")
    public RegistrationPage setPassword(String password) {
        return setTextValue(passwordInput, password, this);
    }

    @Step("Confirm password")
    public RegistrationPage confirmPassword(String confirmPassword) {
        return setTextValue(confirmPasswordInput, confirmPassword, this);
    }

    @Step("Registration")
    public LoginPage register() {
        clickButton(registerButton);
        return new LoginPage();
    }

    @Step("User registration")
    public LoginPage register(User user) {
        return setUsername(user.getUsername())
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setPassword(user.getPassword())
                .confirmPassword(user.getConfirmPassword())
                .register();
    }
}
