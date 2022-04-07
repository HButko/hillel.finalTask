package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import utils.ui.components.CardComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobPage extends BasePage {
    private final SelenideElement jobPageWrapper = $(".job-page");
    private final SelenideElement commentField = jobPageWrapper.$("textarea");
    private final SelenideElement leaveCommentButton = jobPageWrapper.$("mat-card button");
    private final ElementsCollection comments = $$(".comments mat-card");

    public JobPage() {
        jobPageWrapper.should(Condition.exist);
    }

    @Step("Leave comment for the job")
    public JobPage leaveComment(String comment) {
        setTextValue(commentField, comment, this).clickButton(leaveCommentButton);
        leaveCommentButton.shouldBe(Condition.disabled);
        return this;
    }

    @Step("Get total number of comments")
    public int getNumberOfComments() {
        return comments.size();
    }

    @Step("Get comment text")
    public String getComment(int commentIndex) {
        return new CardComponent(comments.snapshot().get(commentIndex-1)).getMainText();
    }
}
