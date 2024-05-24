package cn.bugstack.chatbot.api.test;

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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    @Test
    public void base64(){
        String cronExpression = new String(Base64.getDecoder().decode("MC81MCAqICogKiAqID8="), StandardCharsets.UTF_8);
        System.out.println(cronExpression);
    }

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/你的知识星球ID/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "输入你的cookie");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/你的知识星球ID/answer");
        post.addHeader("cookie", "输入你的cookie");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    //    @Test
//    public void test_chatGPT() throws IOException {
//            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//            // 中转网站
//            String intermediateHost = "api.chatanywhere.com.cn";
//
//            // 目标Host
//            String targetHost = "api.openai.com";
//
//            // 创建请求对象，URL指向中转网站
//            HttpPost post = new HttpPost("https://" + intermediateHost + "/v1/completions");
//            post.addHeader("Content-Type", "application/json");
//            post.addHeader("Authorization", "Bearer sk-ucWDJ7iuUvr0vWnw7zJahUPyXI1CZ5opq83bU95kdXeInBLE");
//
//            // 设置目标Host头
//            post.addHeader("Host", targetHost);
//
//            // 请求参数
//            String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";
//
//            StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
//            post.setEntity(stringEntity);
//
//            // 发送请求并处理响应
//            CloseableHttpResponse response = httpClient.execute(post);
//            try {
//                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                    String res = EntityUtils.toString(response.getEntity());
//                    System.out.println(res);
//                } else {
//                    System.out.println(response.getStatusLine().getStatusCode());
//                }
//            } finally {
//                response.close();
//            }
//        }
    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.chatanywhere.tech/v1/chat/completions");  //中转网站
//        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
//        post.addHeader("Authorization", "Bearer ");
        post.addHeader("Authorization", "Bearer 你的openai-key");

        String paramJson = "{\"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"告诉我怎么冒泡排序\"}],\n" +
                "     \"prompt\": \"告诉我怎么冒泡排序\", \"temperature\": 0.7, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
