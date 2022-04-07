package api.image;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import utils.api.body.UploadImageBody;
import utils.api.enums.ApiList;
import utils.api.enums.Headers;

import java.io.File;
import java.io.IOException;

public class UploadImageObject {
    public String uploadImageFileRequest(String userToken, File file) throws IOException {

        RequestBody requestBody = new UploadImageBody().uploadImageBody(file);

        Request uploadFileRequest = new Request.Builder()
                .url(ApiList.IMAGE_UPLOAD.getUrl())
                .addHeader(Headers.IMAGE.getContentType(), Headers.IMAGE.getValue())
                .addHeader("Authorization", " " + userToken)
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(uploadFileRequest).execute();
        String jsonResponse = new JSONObject(response.body().string()).toString();

        return jsonResponse;
    }
}
