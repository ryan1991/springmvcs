package springmvc4.ch5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc4.ch3.DemoObject;

/**
 * @author songjunbao
 * @createdate 2018/6/22
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert",produces = {"application/x-wisely"})
    public @ResponseBody DemoObject converter(@RequestBody DemoObject demoObject){
        return demoObject;
    }

}
