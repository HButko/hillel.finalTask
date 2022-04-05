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

public class testDeleteJob {

    @Test
    public void deleteJobById() throws IOException {
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

        JSONObject deleteJob = new DeleteJobObject().deleteJob(userToken, jobId);

        String verifyDeletion = deleteJob.getString(JobProperty.MESSAGE.getValue());

        Assert.assertEquals(verifyDeletion, "Job is deleted", "Job is not deleted");
    }
}
