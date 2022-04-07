package api.job;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.JobCreateBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;


public class CreateJobObject {
    public JSONObject createJob(String userToken, int userId, String title, String description, double price) throws IOException {
        RequestBody requestBody = new JobCreateBody().jobCreateBody(userId, title, description, price);

        Request createJobRequest = new Request.Builder()
                .url(ApiList.JOB_CREATE.getUrl())
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(createJobRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
