package utils.ui.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class UserJobsComponent extends BasePage {
    private final SelenideElement userJobsWrapper = $("app-my-jobs");
    private final ElementsCollection myJobs = userJobsWrapper.$$("mat-card");

    public UserJobsComponent() {
        userJobsWrapper.should(Condition.exist);
    }

    @Step("Delete job")
    public UserJobsComponent deleteJob(String title) throws JobNotFoundException {
        SelenideElement job = getJobByTitle(title);
        if (job != null) {
            new CardComponent(job).clickDeleteJob();
            return this;
        } else {
            throw new JobNotFoundException("Cannot find job with title " + title);
        }
    }

    @Step("Check if job is displayed")
    public boolean isJobDisplayed(String title) {
        return getJobByTitle(title) != null;
    }

    private SelenideElement getJobByTitle(String title) {
        if (myJobs.size() == 0) {
            return null;
        } else {
            return myJobs.snapshot().stream().filter(job -> job.$("mat-card-title").text().equals(title))
                    .findFirst().orElse(null);
        }
    }

    public class JobNotFoundException extends Throwable {
        public JobNotFoundException(String massage) {
            super(massage);
        }
    }
}
