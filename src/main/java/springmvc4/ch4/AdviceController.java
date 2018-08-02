package springmvc4.ch4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc4.ch3.DemoObject;

/**
 * @author songjunbao
 * @createdate 2018/6/21
 */
@Controller
public class AdviceController {


    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObject demoObject){
        System.out.println(">>>>demoObject  id: " + demoObject.getId());
        throw new IllegalArgumentException("非常抱歉，参数有误/"+" 来自@ModelAttributes msg:"+msg);
    }


}
