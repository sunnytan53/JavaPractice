package org.sunny.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletInitConfig extends AbstractDispatcherServletInitializer {
    @Override  // load SpringMVC config
    protected WebApplicationContext createServletApplicationContext() {
        // NOTE: this class is ONLY for webapp
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    @Override  // determine what request is handled by SpringMVC
    protected String[] getServletMappings() {
        return new String[]{"/"}; // all request
    }

    @Override  // load Spring config (not MVC)
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
