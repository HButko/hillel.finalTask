package api.user;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.enums.ApiList;

import java.io.IOException;

public class UserInfoObject {
    public JSONObject getUserInfoRequest(String userToken) throws IOException {

        Request userInfoRequest = new Request.Builder()
                .url(ApiList.USER_INFO.getUrl())
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(userInfoRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
