package ui.auth;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseTest;
import ui.pages.HomePage;
import ui.pages.MainPage;
import utils.ui.data.User;
import utils.ui.generators.UserGenerator;

import static com.codeborne.selenide.Selenide.open;

public class testAuth extends BaseTest {
    private User user;

    @BeforeMethod
    public void setUp() {
        String homePageLink = "https://freelance.lsrv.in.ua/home";
        open(homePageLink);

        user = UserGenerator.getUser();
    }

    @Test
    public void testUserRegistration() {
        MainPage mainPage = new HomePage().goToRegistrationPage()
                .register(user)
                .login(user);

        Assert.assertTrue(mainPage.getAllJobs() > 0, "User created and see all jobs");
    }
}
