package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import utils.ui.components.JobFormComponent;
import utils.ui.components.UserComponent;
import utils.ui.components.UserJobsComponent;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {
    private final SelenideElement profilePageWrapper = $(".user-profile");
    private final ElementsCollection buttons = profilePageWrapper.$$("button");
    private final SelenideElement userName = profilePageWrapper.$("h3");

    public final UserJobsComponent userJobs;

    public ProfilePage() {
        profilePageWrapper.should(Condition.exist);
        userJobs = new UserJobsComponent();
    }

    public UserComponent editInfo() {
        clickButton(getButton("Edit Info"));
        return new UserComponent();
    }

    @Step("Close profile and return to the Main page")
    public MainPage closeProfile() {
        clickButton(getButton("Close Profile"));
        return new MainPage();
    }

    @Step("Get current user name and lastname")
    public String getUserName() {
        return userName.text();
    }

    @Step("Click Add Job button and open form")
    public JobFormComponent addJob() {
        clickButton(getButton("Add Job"));
        return new JobFormComponent();
    }

    private SelenideElement getButton(String buttonName) {
        return buttons.snapshot().filter(Condition.text(buttonName)).get(0);
    }
}
