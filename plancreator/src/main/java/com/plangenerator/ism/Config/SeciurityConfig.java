package com.plangenerator.ism.Config;


import com.plangenerator.ism.Handler.CostumeLoginSuccesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;



@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SeciurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CostumeLoginSuccesHandler costumeLoginSuccesHandler;

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {


        authenticationMgr.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select u.username,u.password,true from user u where u.username=?")
                .authoritiesByUsernameQuery(
                        "select u.username, r.name from user u inner join user_role ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id) where u.username=?");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**");

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/resources/**", "/", "/signup", "/forgot-password", "/js/**", "/css/**")
                .permitAll().anyRequest().permitAll()
                .antMatchers("/user/**").hasAnyAuthority("USER")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/v1/User/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/v1/User/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/v1/department/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v1/department/**").permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
                .and().authorizeRequests().antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                .and().authorizeRequests().antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login").permitAll()
                .successHandler(costumeLoginSuccesHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
        http.headers().frameOptions().disable();


    }


}

