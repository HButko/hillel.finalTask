package api.auth;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.SignInRequestBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;

public class SignInObject {
    public JSONObject signInRequest(String userName, String userPassword) throws IOException {

        RequestBody requestBody = new SignInRequestBody().signInRequestBody(userName, userPassword);

        Request signInRequest = new Request.Builder()
                .url(ApiList.SIGN_IN.getUrl())
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signInRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
