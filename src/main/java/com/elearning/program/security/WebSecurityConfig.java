package com.elearning.program.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.elearning.program.handler.CustomAuthenticationFailureHandler;
import com.elearning.program.handler.CustomAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
		.antMatcher("/admin/**")
        .authorizeRequests()
        .antMatchers("/user/**")
        .hasAnyRole("ADMIN", "TEACHER", "STUDENT")
        .antMatchers("/teacher/**")
        .hasAnyRole("ADMIN", "TEACHER")
        .anyRequest().permitAll()
        .and()
        .formLogin()
		.loginPage("/account/login")
        .loginProcessingUrl("/login")
        .usernameParameter("email")
        .passwordParameter("password")
		.defaultSuccessUrl("/admin/user")
        .successHandler(new CustomAuthenticationSuccessHandler())
		.failureUrl("/account/login?error=true")
        .failureHandler(new CustomAuthenticationFailureHandler())
        .and().logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSIONID")
        .and().exceptionHandling()
        .accessDeniedPage("/403");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/statics/**");
  }
}
