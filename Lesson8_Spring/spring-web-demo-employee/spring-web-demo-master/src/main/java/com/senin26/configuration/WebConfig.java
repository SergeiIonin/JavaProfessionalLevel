package com.senin26.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Rewritten by <a href="mailto:sergey.ionin.7@gmail.com">Sergey Ionin</a><br/>
 * based on the project of
 * <a href="mailto:izebit@gmail.com">Artem Konovalov</a> at <a href=https://github.com/izebit/spring-web-demo></a><br/>
 * Creation date: 1/7/18.
 * @since 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("blog/img/**")
                .addResourceLocations("classpath:/static/img/");
    }
}
