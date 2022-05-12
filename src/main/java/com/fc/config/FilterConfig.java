package com.fc.config;

import com.fc.filter.AutoLoginFilter;
import com.fc.filter.RolePermissionsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class FilterConfig {
    private FilterRegistrationBean<Filter> bean;

    @Bean
    FilterRegistrationBean<Filter> autoLoginFilter() {
        bean = new FilterRegistrationBean<>();
        bean.setFilter(new AutoLoginFilter());
        Set<String> set = new HashSet<>();
        set.add("/book_cart.jsp");
        bean.setUrlPatterns(set);
        bean.setOrder(-1);
        return bean;
    }

    @Bean
    FilterRegistrationBean<Filter> RolePermissionsFilter() {
        bean = new FilterRegistrationBean<>();
        bean.setFilter(new RolePermissionsFilter());
        Set<String> set = new HashSet<>();
        set.add("/admin/*");
        bean.setUrlPatterns(set);
        bean.setOrder(0);
        return bean;
    }
}
