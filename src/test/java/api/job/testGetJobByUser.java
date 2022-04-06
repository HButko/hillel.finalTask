package api.job;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import api.user.UserInfoObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static utils.RandomDataGenerator.generate;

public class testGetJobByUser {

    @Test
    public void receiveJobByUser() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String title = generate().randomJobTitle();
        String description = generate().randomJobDescription();
        double price = generate().randomPrice();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        int generatedUserId = userInfo.getInt("id");

        new CreateJobObject().createJob(userToken, generatedUserId, title, description, price);

        List<String> receivedJob = new ReceiveCreatedJobObject().receiveJobByUser(userToken);

        Assert.assertTrue(receivedJob.size() >= 1, "Job is not received");
    }
}