package api.comment;

import api.auth.SignInObject;
import api.auth.SignUpObject;
import api.job.CreateJobObject;
import api.user.UserInfoObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.RandomDataGenerator.generate;

public class testCreateComment {

    @Test
    public void testCreateComment() throws IOException {
        String userName = generate().randomUserName();
        String userPassword = generate().randomUserPass();
        String title = generate().randomJobTitle();
        String description = generate().randomJobDescription();
        double price = generate().randomPrice();
        String message = generate().randomCommentMessage();
        String commentDate = generate().randomCommentDate();

        new SignUpObject().signUpRequest(userName, userPassword);

        String userToken = new SignInObject().signInRequest(userName, userPassword).getString("token");
        JSONObject userInfo = new UserInfoObject().getUserInfoRequest(userToken);
        int generatedUserId = userInfo.getInt("id");

        int jobId = new CreateJobObject().createJob(userToken, generatedUserId, title, description, price).getInt("id");

        JSONObject createComment = new CommentObject().createCommentRequest(userToken, jobId, generatedUserId, userName, message, commentDate);

        String verifyCommentCreated = createComment.getString("message");

        Assert.assertEquals(verifyCommentCreated, userName, "Comment is not created");
    }
}
