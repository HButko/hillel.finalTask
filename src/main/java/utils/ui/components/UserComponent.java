package utils.ui.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import ui.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class UserComponent extends BasePage {
    private final SelenideElement dialogWrapper = $("mat-dialog-container");
    private final SelenideElement editUserNameInput = dialogWrapper.$("input[formcontrolname='name']");
    private final SelenideElement editUserLastnameInput = dialogWrapper.$("input[formcontrolname='lastname']");
    private final SelenideElement updateEditButton = dialogWrapper.$("button.mat-primary");

    public UserComponent() {
        dialogWrapper.shouldBe(Condition.exist);
    }

    @Step("Set user name")
    public UserComponent setName(String name) {
        return setTextValue(editUserNameInput.should(Condition.visible), name, this);
    }

    @Step("Set user lastname")
    public UserComponent setLastname(String lastname) {
        return setTextValue(editUserLastnameInput.should(Condition.visible), lastname, this);
    }

    @Step("Save user info")
    public ProfilePage saveUserInfo() {
        clickButton(updateEditButton);
        updateEditButton.shouldNot(Condition.exist);
        return new ProfilePage();
    }
}
