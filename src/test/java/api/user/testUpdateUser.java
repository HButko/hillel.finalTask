package api.user;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.api.enums.UserProperty;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testUpdateUser {
    @Test
    public void testUpdateUser() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String name = generate().randomName();
        String lastName = generate().randomLastName();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        int generatedUserId = userInfo.getInt("id");

        JSONObject updateRequest = new UserUpdateObject().userUpdateRequest(userToken, generatedUserId, userName, name, lastName);

        String verifyName = updateRequest.getString(UserProperty.NAME.getValue());
        String verifyLastName = updateRequest.getString(UserProperty.LAST_NAME.getValue());

        Assert.assertEquals(name, verifyName, "User name is incorrect");
        Assert.assertEquals(lastName, verifyLastName, "User last name is incorrect");
    }
}
