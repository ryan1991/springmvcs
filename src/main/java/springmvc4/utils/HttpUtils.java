package springmvc4.utils;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songjunbao
 * @createdate 2018/6/20
 */
public class HttpUtils {

    private static CloseableHttpClient httpClient;
    public static final String CHARSET = "UTF-8";
    static {
        System.out.println("static do ...");

        if (httpClient == null){
            RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
            httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        }

    }

    /**
     * http get请求
     * @param url
     * @param params
     * @return
     */
    public static String sendGet(String url, Map<String, Object> params){
        if (!StringUtils.hasText(url)){
            return "";
        }
        try {

            if (!CollectionUtils.isEmpty(params)){
                List<NameValuePair> pairs = new ArrayList<>(params.size());
                for (String key :params.keySet()){
                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs,CHARSET));
            }
            System.out.println(">>>>>>>>>>url:"+ url);

            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != 200){
                httpGet.abort();
                throw new RuntimeException("HttpClient error ,status code :"+statusCode);
            }
            HttpEntity entity = httpResponse.getEntity();
            String result = null;
            if (entity !=null) {
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            httpResponse.close();
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * http post 请求
     * @param url
     * @param params
     * @return
     */
    public static String sendPost(String url, Map<String, Object> params){
        if (!StringUtils.hasText(url)){
            return "";
        }

        try {
            List<NameValuePair> pairs = new ArrayList<>();
            if (!CollectionUtils.isEmpty(params)){
                for (Map.Entry<String, Object> entry : params.entrySet()){
                    pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            HttpPost httpPost = new HttpPost(url);

            if (!CollectionUtils.isEmpty(pairs)){
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }

            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if(statusCode != 200){
                httpPost.abort();
                throw new RuntimeException("HttpClient error status code :" + statusCode);
            }
            HttpEntity entity = httpResponse.getEntity();
            String result = null;
            if (entity != null){
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            httpResponse.close();
            return result;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


}
