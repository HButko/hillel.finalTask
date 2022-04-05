package api.job;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DeleteJobObject {
    public JSONObject deleteJob(String userToken, int jobId) throws IOException {
        RequestBody requestBody = RequestBody.create("".getBytes(StandardCharsets.UTF_8));

        Request signInRequest = new Request.Builder()
                .url(ApiList.JOB_DELETE.getUrl() + jobId)
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signInRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
