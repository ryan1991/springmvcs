package springmvc4.ch3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjunbao
 * @createdate 2018/6/20
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {


    @RequestMapping(value = "/getJson", produces = {"application/json;charset=UTF-8"})
    public DemoObject getJson(){
        DemoObject object = new DemoObject();
        object.setId(1000L);
        object.setName("songxiyu");
        return object;
    }


    @RequestMapping(value = "/getXml", produces = {"application/xml;charset=UTF-8"})
    public DemoObject getXml(){
        DemoObject object = new DemoObject();
        object.setId(200L);
        object.setName("jianghua");
        return object;
    }


}
