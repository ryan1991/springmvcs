package springmvc4.ch3;

import springmvc4.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songjunbao
 * @createdate 2018/6/20
 */
public class HttpsUtilTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080/rest/getXml";
        Map<String, Object> params = new HashMap<>();

       String response =  HttpUtils.sendPost(url, params);
       System.out.println(">>>>>>>>>>>response:"+response);

    }



}
