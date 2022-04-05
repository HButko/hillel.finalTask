package utils.api.body;

import okhttp3.RequestBody;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class UserUpdateBody {
    public RequestBody userUpdateBodyRequest(int userId, String userName, String name, String lastName) {
        JSONObject requestJson = new JSONObject("{\n" +
                "  \"id\": " + userId + ",\n" +
                "  \"username\": \"" + userName + "\",\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"lastname\": \"" + lastName + "\"\n" +
                "}");

        RequestBody requestBody = RequestBody.create(requestJson.toString().getBytes(StandardCharsets.UTF_8));

        return requestBody;
    }
}
