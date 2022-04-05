package api.job;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;

public class ReceiveCreatedJobObject {
    public JSONObject receiveJob(String userToken,  int jobId) throws IOException {

        Request signInRequest = new Request.Builder()
                .url(ApiList.JOB_ID.getUrl() + jobId)
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signInRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
