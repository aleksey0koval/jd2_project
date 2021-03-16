package it.academy.web.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebProjectSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebProjectSecurityInitializer(){
        super(WebProjectSecurityConfiguration.class);
    }
}
