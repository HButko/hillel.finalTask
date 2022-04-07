package ui.user;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.ProfilePage;
import utils.ui.data.User;
import utils.ui.generators.UserGenerator;

import static com.codeborne.selenide.Selenide.open;

public class testLoginAndUpdate {
    private User user;

    @BeforeMethod
    public void setUp() {
        String homePageLink = "https://freelance.lsrv.in.ua/home";
        open(homePageLink);

        user = UserGenerator.getUser();
    }

    @Test
    public void loginAndUpdateUserInfoTest() {
        ProfilePage userProfile = new HomePage().goToRegistrationPage()
                .register(user)
                .login(user)
                .header
                .goToProfile();

        user = UserGenerator.createUser();
        userProfile.editInfo()
                .setName(user.getName())
                .setLastname(user.getLastname())
                .saveUserInfo();

        Assert.assertEquals(userProfile.getUserName(), String.format("%s %s", user.getName(), user.getLastname()),
                "Information is updated");
    }
}
