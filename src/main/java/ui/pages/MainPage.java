package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.BasePage;
import utils.ui.Headers;
import utils.ui.components.CardComponent;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement mainPageWrapper = $(".index-page");
    private final ElementsCollection jobs = mainPageWrapper.$$("mat-card");

    public Headers header;

    public MainPage() {
        mainPageWrapper.should(Condition.exist);
        header = new Headers();
    }

    @Step("Open job details page")
    public JobPage viewJobDetails(String jobTitle) throws JobNotFoundException {
        SelenideElement job = getJobByTitle(jobTitle);
        if (job != null) {
            new CardComponent(getJobByTitle(jobTitle)).clickViewDetails();
            return new JobPage();
        } else {
            throw new JobNotFoundException("Cannot find job with title: " + jobTitle);
        }

    }

    @Step("Get total number of displayed page")
    public int getAllJobs() {
        return jobs.size();
    }

    private SelenideElement getJobByTitle(String jobTitle) {
        return jobs.snapshot().stream().filter(job -> job.$("mat-card-title").text().equals(jobTitle)).findFirst()
                .orElse(null);
    }

    public class JobNotFoundException extends Throwable {
        public JobNotFoundException(String message) {
            super(message);
        }
    }
}
