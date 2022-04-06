package api.job;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;
import java.util.List;

public class ReceiveCreatedJobObject {
    public JSONObject receiveJob(String userToken,  int jobId) throws IOException {

        Request receiveJobRequest = new Request.Builder()
                .url(ApiList.JOB_ID.getUrl() + jobId)
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(receiveJobRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }

    public List<String> receiveJobByUser(String userToken) throws IOException {

        Request receiveJobRequest = new Request.Builder()
                .url(ApiList.JOB_USER.getUrl())
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(receiveJobRequest).execute();

        return new Gson().fromJson(response.body().string(), new TypeToken<List<JSONObject>>(){}.getType());
    }

    public List<String> receiveAllJobs(String userToken) throws IOException {

        Request receiveJobRequest = new Request.Builder()
                .url(ApiList.JOB_ALL.getUrl())
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(receiveJobRequest).execute();

        return new Gson().fromJson(response.body().string(), new TypeToken<List<JSONObject>>(){}.getType());
    }
}
