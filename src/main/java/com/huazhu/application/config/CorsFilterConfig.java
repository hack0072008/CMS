package com.huazhu.application.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsFilterConfig {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean 
	public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        ArrayList<String> objects = new ArrayList<>();
        objects.add("*");
        config.setAllowedOrigins(objects);
        config.setAllowedHeaders(objects);
        config.setAllowedMethods(objects);      
        //source.registerCorsConfiguration("/**", config);
        Map<String, CorsConfiguration> corsConfigurations = new HashMap<>();
        corsConfigurations.put("/**",config);
        source.setCorsConfigurations(corsConfigurations);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }


}
