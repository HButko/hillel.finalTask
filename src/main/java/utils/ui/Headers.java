package utils.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import ui.pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class Headers extends BasePage {
    private SelenideElement headerWrapper = $("mat-toolbar");
    private SelenideElement profileButton = headerWrapper.$("button[mattooltip='Profile']");
    private SelenideElement profileMenuItem = $(".mat-menu-content button:nth-of-type(1)");

    public Headers() {
        headerWrapper.should(Condition.exist);
    }

    @Step("Go to the Profile")
    public ProfilePage goToProfile() {
        clickButton(profileButton);
        clickButton(profileMenuItem.should(Condition.exist));
        return new ProfilePage();
    }
}
