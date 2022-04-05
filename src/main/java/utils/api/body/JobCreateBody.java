package utils.api.body;

import okhttp3.RequestBody;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class JobCreateBody {
    public RequestBody jobCreateBody(int userId, String title, String description, double price) {
        JSONObject requestJson = new JSONObject("{\n" +
                "  \"id\": " + userId + ",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"price\": " + price + "\n" +
                "}");

        RequestBody requestBody = RequestBody.create(requestJson.toString().getBytes(StandardCharsets.UTF_8));

        return requestBody;
    }
}
