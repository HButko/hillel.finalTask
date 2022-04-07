package utils.api.body;

import okhttp3.RequestBody;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class CommentBody {
    public RequestBody commentRequestBody(int userId, String userName, String message, String commentDate) {
        JSONObject requestJson = new JSONObject("{\n" +
                "        \"id\": " + userId + ",\n" +
                "            \"message\": \"" + userName + "\",\n" +
                "            \"username\": \"" + message + "\",\n" +
                "            \"commentDate\": \"" + commentDate + "\"\n" +
                "    }");

        RequestBody requestBody = RequestBody.create(requestJson.toString().getBytes(StandardCharsets.UTF_8));

        return requestBody;
    }
}
