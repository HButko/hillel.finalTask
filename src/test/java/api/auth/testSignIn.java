package api.auth;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testSignIn {
    @Test
    public void testSignIn() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();

        new SignUpObject().signUpRequest(userName, userPassword);

        JSONObject signInResponse = new SignInObject().signInRequest(userName, userPassword);

        boolean verifyResponse = signInResponse.getBoolean("success");
        Assert.assertTrue(verifyResponse, "User is not signed in");
    }
}
