//package com.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // No need for @Autowired here
//    // private BCryptPasswordEncoder passwordEncoder; // Remove @Autowired
//
//    // Configure in-memory authentication (replace with your user details)
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("pratik")
//            .password(passwordEncoder().encode("pratik123"))
//            .roles("USER");
//    }
//
//    // Configure security settings
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()  // Disable CSRF for simplicity (enable it in production)
//            .authorizeRequests()
//            .antMatchers("/user/newUser").permitAll()  // Allow all access to this endpoint
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
