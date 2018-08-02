package springmvc4.ch5;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import springmvc4.ch3.DemoObject;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 自定义消息转化
 *
 * @author songjunbao
 * @createdate 2018/6/22
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObject>{

    public MyMessageConverter(){
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }


    @Override
    protected boolean supports(Class<?> clazz) {
        //只支持DemoObject类型
        return DemoObject.class.isAssignableFrom(clazz);
    }

    @Override
    protected DemoObject readInternal(Class<? extends DemoObject> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        DemoObject demoObject = new DemoObject();
        demoObject.setId(new Long(tempArr[0]));
        demoObject.setName(tempArr[1]);
        return demoObject;
    }

    @Override
    protected void writeInternal(DemoObject demoObject, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello :" + demoObject.getId() + "-" + demoObject.getName();
        outputMessage.getBody().write(out.getBytes());

    }
}
