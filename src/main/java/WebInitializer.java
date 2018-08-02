import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

;import java.util.EnumSet;

/**
 * 取代web.xml
 * @author songjunbao
 * @createdate 2018/6/13
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding","UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
