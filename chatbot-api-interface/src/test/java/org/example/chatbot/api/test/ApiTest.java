package org.example.chatbot.api.test;

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

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885184812482/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218b5d48ec73b89-0ce3464dad8bd58-745d5771-2710825-18b5d48ec7421d7%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiNWQ0OGVjNzNiODktMGNlMzQ2NGRhZDhiZDU4LTc0NWQ1NzcxLTI3MTA4MjUtMThiNWQ0OGVjNzQyMWQ3In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218b5d48ec73b89-0ce3464dad8bd58-745d5771-2710825-18b5d48ec7421d7%22%7D; zsxq_access_token=C821587C-CC4A-3972-13BD-678110966C26_8639674579F185ED; abtest_env=product; zsxqsessionid=25dd140cda32c4687bd55212904bee07");
        get.addHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
//            String input = "\\u77e5\\u8bc6\\u661f\\u7403\\u4e3a\\u4ec0\\u4e48\\u4e00\\u5b9a\\u8981\\u4ed8\\u8d39\\u0021";
//            StringBuilder sb = new StringBuilder();
//            String[] hexArray = input.split("\\\\u");
//            for (int i = 1; i < hexArray.length; i++) {
//                int hexValue = Integer.parseInt(hexArray[i], 16);
//                sb.append((char) hexValue);
//            }
//            System.out.println(sb.toString());
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/411554125524488/answer");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2218b5d48ec73b89-0ce3464dad8bd58-745d5771-2710825-18b5d48ec7421d7%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiNWQ0OGVjNzNiODktMGNlMzQ2NGRhZDhiZDU4LTc0NWQ1NzcxLTI3MTA4MjUtMThiNWQ0OGVjNzQyMWQ3In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%2218b5d48ec73b89-0ce3464dad8bd58-745d5771-2710825-18b5d48ec7421d7%22%7D; zsxq_access_token=C821587C-CC4A-3972-13BD-678110966C26_8639674579F185ED; abtest_env=product; zsxqsessionid=25dd140cda32c4687bd55212904bee07");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"赫赫,爱用用不用滚\\n\",\n" +
                "    \"image_ids\": []\n" +
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
}
