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

public class testJobCreate {

    @Test
    public void createJob() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String title = generate().randomJobTitle();
        String description = generate().randomJobDescription();
        double price = generate().randomPrice();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        int generatedUserId = userInfo.getInt("id");

        JSONObject createJobRequest = new CreateJobObject().createJob(userToken, generatedUserId, title, description, price);

        String verifyTitle = createJobRequest.getString(JobProperty.TITLE.getValue());
        String verifyDescription = createJobRequest.getString(JobProperty.DESCRIPTION.getValue());

        Assert.assertEquals(title, verifyTitle, "Job title is incorrect");
        Assert.assertEquals(description, verifyDescription, "Job description is incorrect");
    }
}
