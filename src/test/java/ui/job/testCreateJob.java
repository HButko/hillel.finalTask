package ui.job;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HomePage;
import ui.pages.ProfilePage;
import utils.ui.data.Job;
import utils.ui.data.User;
import utils.ui.generators.UserGenerator;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomDataGenerator.generate;

public class testCreateJob extends BaseTest {
    private User user;

    @BeforeMethod
    public void setUp() {
        String homePageLink = "https://freelance.lsrv.in.ua/home";
        open(homePageLink);

        user = UserGenerator.getUser();
    }

    @Test
    public void createNewJobTest() {
        Job job = new Job();
        job.setTitle(generate().randomJobTitle());
        job.setDescription(generate().randomJobDescription());
        job.setPrice(generate().randomPrice());

        ProfilePage jobPage = new HomePage().goToRegistrationPage()
                .register(user)
                .login(user)
                .header.goToProfile()
                .addJob()
                .setTitle(job.getTitle())
                .setDescription(job.getDescription())
                .setPrice(job.getPrice())
                .addJob();

        Assert.assertTrue(jobPage.userJobs.isJobDisplayed(job.getTitle()), "Job is not created");
    }
}
