package ui.job;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HomePage;
import utils.ui.components.UserJobsComponent;
import utils.ui.data.Job;
import utils.ui.data.User;
import utils.ui.generators.UserGenerator;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomDataGenerator.generate;

public class testDeleteJob extends BaseTest {
    private User user;

    @BeforeMethod
    public void setUp() {
        String homePageLink = "https://freelance.lsrv.in.ua/home";
        open(homePageLink);

        user = UserGenerator.getUser();
    }

    @Test
    public void deleteJobTest() throws UserJobsComponent.JobNotFoundException {
        Job job = new Job();
        job.setTitle(generate().randomJobTitle());
        job.setDescription(generate().randomJobDescription());
        job.setPrice(generate().randomPrice());

        UserJobsComponent userJob = new HomePage().goToRegistrationPage()
                .register(user)
                .login(user)
                .header.goToProfile()
                .addJob()
                .setTitle(job.getTitle())
                .setDescription(job.getDescription())
                .setPrice(job.getPrice())
                .addJob()
                .userJobs;

        userJob.deleteJob(job.getTitle());

        Assert.assertFalse(userJob.isJobDisplayed(job.getTitle()), "Job is not deleted");
    }
}
