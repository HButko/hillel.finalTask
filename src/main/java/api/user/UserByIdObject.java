package api.user;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.enums.ApiList;

import java.io.IOException;

public class UserByIdObject {
    public int getUserByIdRequest(int userId, String userToken) throws IOException {

        Request userByIdRequest = new Request.Builder()
                .url(ApiList.USER_INFO.getUrl() + userId)
                .addHeader("Authorization", " " + userToken)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(userByIdRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());
        int requestedUserId = jsonResponse.getInt("id");

        return requestedUserId;
    }
}
