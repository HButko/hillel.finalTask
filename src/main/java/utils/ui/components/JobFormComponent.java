package utils.ui.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import ui.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class JobFormComponent extends BasePage {
    private final SelenideElement addJobWrapper = $("app-add-job");
    private final SelenideElement titleInput = addJobWrapper.$("input[formcontrolname='title']");
    private final SelenideElement descTextarea = addJobWrapper.$("textarea[formcontrolname='description']");
    private final SelenideElement priceInput = addJobWrapper.$("input[formcontrolname='price']");
    private final SelenideElement addJobButton = addJobWrapper.$("form button");

    public JobFormComponent() {
        addJobWrapper.should(Condition.exist);
    }

    @Step("Set job title")
    public JobFormComponent setTitle(String title) {
        return setTextValue(titleInput, title, this);
    }

    @Step("Set job description")
    public JobFormComponent setDescription(String description) {
        return setTextValue(descTextarea, description, this);
    }

    @Step("Set job price")
    public JobFormComponent setPrice(double price) {
        return setTextValue(priceInput, String.valueOf(price), this);
    }

    @Step("Save new job")
    public ProfilePage addJob() {
        clickButton(addJobButton);
        return new ProfilePage();
    }
}
