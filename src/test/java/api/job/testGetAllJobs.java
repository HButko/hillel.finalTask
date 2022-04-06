package api.job;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static utils.RandomDataGenerator.generate;

public class testGetAllJobs {

    @Test
    public void receiveAllJobs() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");

        List<String> receivedJob = new ReceiveCreatedJobObject().receiveAllJobs(userToken);

        Assert.assertTrue(receivedJob.size() >= 1, "Job is not received");
    }
}
