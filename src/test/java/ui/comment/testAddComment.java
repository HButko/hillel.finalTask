package ui.comment;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HomePage;
import ui.pages.JobPage;
import ui.pages.MainPage;
import utils.ui.data.Job;
import utils.ui.data.User;
import utils.ui.generators.UserGenerator;

import static com.codeborne.selenide.Selenide.open;
import static utils.RandomDataGenerator.generate;

public class testAddComment extends BaseTest {
    private User user;

    @BeforeMethod
    public void setUp() {
        String homePageLink = "https://freelance.lsrv.in.ua/home";
        open(homePageLink);

        user = UserGenerator.getUser();
    }

    @Test
    public void testCommentJob() throws MainPage.JobNotFoundException {
        String message = generate().randomCommentMessage();

        Job job = new Job();
        job.setTitle(generate().randomJobTitle());
        job.setDescription(generate().randomJobDescription());
        job.setPrice(generate().randomPrice());

        JobPage userComment = new HomePage().goToRegistrationPage()
                .register(user)
                .login(user)
                .header.goToProfile()
                .addJob()
                .setTitle(job.getTitle())
                .setDescription(job.getDescription())
                .setPrice(job.getPrice())
                .addJob()
                .closeProfile()
                .viewJobDetails(job.getTitle())
                .leaveComment(message);

        Assert.assertEquals(userComment.getNumberOfComments(), 1,
                "Comment should be displayed");
        Assert.assertEquals(userComment.getComment(1), message,
                "Wrong comment is displayed");
    }
}
