package api.user;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testRequestUserInfo {
    @Test
    public void testUserInfo() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();

        new SignUpObject().signUpRequest(userName, userPassword);

        JSONObject signInResponse = new SignInObject().signInRequest(userName, userPassword);

        String userToken = signInResponse.getString("token");

        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);

        String verifyUserName = userInfo.getString("username");
        Assert.assertEquals(userName, verifyUserName, "User info is not received");
    }
}
