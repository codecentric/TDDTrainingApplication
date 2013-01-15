package nl.codecentric.training.tdd.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * User: Hylke Stapersma
 * Company: codecentric
 * Date: 15-01-13
 */
public class CopyWebContextParamsListener implements ServletContextListener {

    private final static String PARAM_SYSTEM_PROPERTY_PREFIX = "contextParam_";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Enumeration enumeration = servletContextEvent.getServletContext().getInitParameterNames();
        System.out.println("Loading context params");
        while(enumeration.hasMoreElements()){
            String paramName = (String)enumeration.nextElement();
            System.setProperty(PARAM_SYSTEM_PROPERTY_PREFIX+paramName,servletContextEvent.getServletContext().getInitParameter(paramName));
            System.out.println(String.format("Setting system property %s with value %s",PARAM_SYSTEM_PROPERTY_PREFIX+paramName,servletContextEvent.getServletContext().getInitParameter(paramName)));
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
