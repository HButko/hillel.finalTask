package utils.api.body;

import okhttp3.RequestBody;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class SignInRequestBody {
    public RequestBody signInRequestBody(String userName, String userPassword) {

        JSONObject requestJson = new JSONObject("{\n" +
                "  \"username\": \"" + userName + "\",\n" +
                "  \"password\": \"" + userPassword + "\"\n" +
                "}");

        RequestBody requestBody = RequestBody.create(requestJson.toString().getBytes(StandardCharsets.UTF_8));

        return requestBody;
    }
}
