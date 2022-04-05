package api.job;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import api.user.UserInfoObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.api.enums.JobProperty;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testGetJobById {

    @Test
    public void receiveJobById() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String title = generate().randomJobTitle();
        String description = generate().randomJobDescription();
        double price = generate().randomPrice();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        int generatedUserId = userInfo.getInt("id");

        int jobId = new CreateJobObject().createJob(userToken, generatedUserId, title, description, price).getInt("id");

        JSONObject createdJobInfo = new ReceiveCreatedJobObject().receiveJob(userToken, jobId);

        String verifyJobTitle = createdJobInfo.getString(JobProperty.TITLE.getValue());
        String verifyJobDescription = createdJobInfo.getString(JobProperty.DESCRIPTION.getValue());
        double verifyJobPrice = createdJobInfo.getDouble("price");

        Assert.assertEquals(title, verifyJobTitle, "Job title is incorrect");
        Assert.assertEquals(description, verifyJobDescription, "Job description is incorrect");
        Assert.assertEquals(price, verifyJobPrice, "Job price is incorrect");
    }
}