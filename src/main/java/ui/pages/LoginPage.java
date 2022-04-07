package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import utils.ui.data.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final SelenideElement loginPageWrapper = $(".login-page");
    private final SelenideElement usernameInput = loginPageWrapper.$("input[formcontrolname='username']");
    private final SelenideElement passwordInput = loginPageWrapper.$("input[formcontrolname='password']");
    private final SelenideElement loginButton = loginPageWrapper.$("button");

    public LoginPage() {
        loginPageWrapper.should(Condition.exist);
    }

    @Step("Set username")
    public LoginPage setUsername(String username) {
        return setTextValue(usernameInput, username, this);
    }

    @Step("Set password")
    public LoginPage setPassword(String password) {
        return setTextValue(passwordInput, password, this);
    }

    @Step("Login")
    public MainPage login() {
        clickButton(loginButton);
        return new MainPage();
    }

    @Step("Login")
    public MainPage login(User user) {
        return setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .login();
    }
}
