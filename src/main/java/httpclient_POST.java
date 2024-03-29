import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.json.simple.JSONObject;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class httpclient_POST {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("https://gorest.co.in/public/v2/users");
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Authorization", "Bearer 1d223849ee348038c8ab3078d4759c2f9fab5b81921da28db3027fe25dfa1c27");
            StringBuilder nameObject = new StringBuilder();
            nameObject.append("{");
            nameObject.append("\"name\":\"Deeksha\",");
            nameObject.append("\"email\":\"Deeksha.Singh@geminisolutions\",");
            nameObject.append("\"gender\":\"female\",");
            nameObject.append("\"status\":\"active\"");
            nameObject.append("}");

            StringEntity entity = new StringEntity(nameObject.toString());
            httpPost.setEntity(entity);
            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println(response.getStatusLine().getStatusCode());
            client.close();
        } catch (Exception e) {


        }
    }
}
