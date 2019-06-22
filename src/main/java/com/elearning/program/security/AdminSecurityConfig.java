package com.elearning.program.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

@Configuration
@EnableWebSecurity
@ComponentScan("com.elearning.program")
@Order(1)
public class AdminSecurityConfig extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	protected void configure(HttpSecurity httpSecurity) throws Exception {
	httpSecurity.csrf()
	.disable()
//	.antMatcher("/admin/**")
	.authorizeRequests()
	.antMatchers("/admin/**")
	.hasAnyRole("ADMIN")
//	.anyRequest()
//	.permitAll()
	.and()
	.formLogin()
		.loginPage("/admin/login")
		.loginProcessingUrl("/admin/login")
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/admin/category")
		.failureUrl("/admin/login?error=deny")
	.and()
		.logout()
			.logoutUrl("/admin/logout")
			.logoutSuccessUrl("/admin/login")
			.deleteCookies("JSESSIONID")
	.and()
	.exceptionHandling()
	.accessDeniedPage("/admin/403");
	}

	public void configure(WebSecurity builder) throws Exception {
		builder.ignoring().antMatchers("/statics/**");
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

}
