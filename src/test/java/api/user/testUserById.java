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

        JSONObject signInResponse = new SignInObject().signInRequest(userName, userPassword);

        String userToken = signInResponse.getString("token");
        System.out.println(userToken);
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        System.out.println(userInfo);
//        String userId = userInfo.getString("id");
//
//        JSONObject verifyUserById = new UserByIdObject().getUserByIdRequest(userId);
//
//        Assert.assertEquals(userId, verifyUserById, "User has wrong data");
    }
}
