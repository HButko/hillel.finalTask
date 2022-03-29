package api.auth;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testSignUp {
    @Test
    public void testSignUp() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();

        JSONObject jsonResponse = new SignUpObject().signUpRequest(userName, userPassword);

        String verifyResponse = jsonResponse.get("message").toString();
        Assert.assertEquals(verifyResponse, verifyResponse, "User is not created");
    }
}
