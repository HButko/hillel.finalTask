package api.user;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testUserById {

    @Test
    public void testUserInfoById() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");

        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);

        int userId = userInfo.getInt("id");
        int verifyUserById = new UserByIdObject().getUserByIdRequest(userId, userToken);

        Assert.assertEquals(userId, verifyUserById, "User has wrong data");
    }
}
