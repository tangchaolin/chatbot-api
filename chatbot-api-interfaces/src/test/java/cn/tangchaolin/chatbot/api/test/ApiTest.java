package cn.tangchaolin.chatbot.api.test;

import com.sun.tools.javac.util.DefinedBy;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void query_unanswered_quesions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("http://127.0.0.1:8000/post?id=1332682473151635458");


        get.setHeader("cookie","");

        get.setHeader("Content-Type","application/json");

        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            logger.debug(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());

        }
    }


    @Test
    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("http://localhost:8000/comment/add_comment");

        post.addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6InpoYW5neWFsaSIsImV4cCI6MTY4NzQ4MDcxMH0.azvUHvck6042AsBUP3nCw7OqnvAfKL4pREBiHdV9r3FFLQLn5wtXjJqdiJKC-wx0ybwkJPWbRcpluTAP7IT5bw");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"content\": \"其实问题很大。\",\n" +
                "  \"topic_id\": \"1332682473151635458\"\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));


        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity()
            );
            logger.debug(res);
        }
        else {
            System.out.println(response.getStatusLine().getStatusCode());

        }
    }

}

