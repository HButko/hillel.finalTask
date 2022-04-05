package api.user;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.UserUpdateBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;

public class UserUpdateObject {
    public JSONObject userUpdateRequest(String userToken, int userId, String userName, String name, String lastName) throws IOException {

        RequestBody requestBody = new UserUpdateBody().userUpdateBodyRequest(userId, userName, name, lastName);

        Request signInRequest = new Request.Builder()
                .url(ApiList.USER_UPDATE.getUrl())
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
