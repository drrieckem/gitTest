package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrossOrangeConfig {

    private static final long MAX_AGE = 24 * 60 * 60;//当前跨域的请求的最大时常，默认为一天

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");//1.设置访问源地址
        configuration.addAllowedMethod("*");//2.设置访问源请求头
        configuration.addAllowedHeader("*");//3.设置访问源请求方法
        configuration.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**",configuration);//4.对接口配置跨域设置
        return new CorsFilter(source);

    }

}
