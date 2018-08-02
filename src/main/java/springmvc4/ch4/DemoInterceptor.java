package springmvc4.ch4;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author songjunbao
 * @createdate 2018/6/21
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute("startTime", start);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime =(Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        System.out.println("本次请求处理时间：" + (System.currentTimeMillis() - startTime) + " ms");
        request.setAttribute("handTime", (System.currentTimeMillis() - startTime) );

    }
}
