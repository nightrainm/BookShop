package com.fc.config;

import com.fc.filter.AutoLoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class FilterConfig {
    @Bean
    FilterRegistrationBean<Filter> autoLoginFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AutoLoginFilter());

        Set<String> set = new HashSet<>();
        set.add("/book_cart.jsp");

        bean.setUrlPatterns(set);
        return bean;
    }
}
