package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
//    链式编程
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只能对应有权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
//        没有权限转到登录页面,需要开启登陆页面，否则会到默认的login
        http.formLogin().disable();
        http.formLogin().loginPage("/toLogin");
//        注销跳转到首页
        http.logout().logoutSuccessUrl("/toLogin");
//        http.logout().logoutUrl("/toLogin");
//        防止网站攻击
        http.csrf().disable();//关闭csrf功能
        http.rememberMe().rememberMeParameter("remember");


    }

    //认证的规则, spring boot 2.1.x.可以直接使用。
//    密码编码加密
//    spring5.0中加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("drrickem").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
                .and().
                withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3");

    }
}

