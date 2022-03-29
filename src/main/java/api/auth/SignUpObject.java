package api.auth;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.SignUpRequestBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.IOException;

public class SignUpObject {
    public JSONObject signUpRequest(String userName, String userPassword) throws IOException {

        RequestBody requestBody = new SignUpRequestBody().signUpRequestBody(userName, userPassword);

        Request signUpRequest = new Request.Builder()
                .url(ApiList.SIGN_UP.getUrl())
                .addHeader(Headers.JSON.getContentType(), Headers.JSON.getValue())
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(signUpRequest).execute();
        JSONObject jsonResponse = new JSONObject(response.body().string());

        return jsonResponse;
    }
}
