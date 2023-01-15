package org.sunny.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// public class ServletInitConfig extends AbstractDispatcherServletInitializer {
//     @Override  // load SpringMVC config
//     protected WebApplicationContext createServletApplicationContext() {
//         // NOTE: this class is ONLY for webapp
//         AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//         ctx.register(SpringMvcConfig.class);
//         return ctx;
//     }
//
//     @Override  // determine what request is handled by SpringMVC
//     protected String[] getServletMappings() {
//         return new String[]{"/"}; // all request
//     }
//
//     @Override  // load Spring config (not MVC)
//     protected WebApplicationContext createRootApplicationContext() {
//         return null;
//     }
// }

public class ServletInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
