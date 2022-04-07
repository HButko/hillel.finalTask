package api.comment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.CommentBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;
import java.util.List;

public class CommentObject {
    public JSONObject createCommentRequest(String userToken, int jobId, int userId, String userName, String message, String commentDate) throws IOException {

        RequestBody requestBody = new CommentBody().commentRequestBody(userId, userName, message, commentDate);

        Request signInRequest = new Request.Builder()
                .url(ApiList.COMMENT.getUrl() + jobId + "/create")
                .addHeader("Authorization", " " + userToken)
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signInRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }

    public List<String> receiveAllCommentsRequest(String userToken, int jobId) throws IOException {

        Request signInRequest = new Request.Builder()
                .url(ApiList.COMMENT.getUrl() + jobId + "/all")
                .addHeader("Authorization", " " + userToken)
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signInRequest).execute();

        return new Gson().fromJson(response.body().string(), new TypeToken<List<JSONObject>>(){}.getType());
    }
}
