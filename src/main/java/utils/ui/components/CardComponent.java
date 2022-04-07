package utils.ui.components;

import com.codeborne.selenide.SelenideElement;
import ui.BasePage;

import static com.codeborne.selenide.Selenide.switchTo;

public class CardComponent extends BasePage {
    private final SelenideElement mainText;
    private final SelenideElement jobComments;
    private final SelenideElement viewDetailsButton;
    private final SelenideElement deleteJobButton;

    public CardComponent(SelenideElement parent) {
        mainText = parent.$("mat-card-content");
        jobComments = parent.$("mat-card-subtitle[align='end']");
        viewDetailsButton = parent.$("button");
        deleteJobButton = parent.$("button.mat-warn");
    }

    public String getMainText() {
        return mainText.text();
    }

    public void clickViewDetails() {
        clickButton(viewDetailsButton);
    }

    public void clickDeleteJob() {
        clickButton(deleteJobButton);
        switchTo().alert().accept();
    }

    public int getComments() {
        return Integer.parseInt(jobComments.text().split(":")[1].trim());
    }
}
