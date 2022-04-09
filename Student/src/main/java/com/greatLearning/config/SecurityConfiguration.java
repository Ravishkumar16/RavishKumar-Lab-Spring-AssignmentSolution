package com.greatLearning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.greatLearning.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
			.cors()
				.disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/students/search/**").hasAnyAuthority("USER", "ADMIN")
				.antMatchers(HttpMethod.POST,"/students/save").hasAnyAuthority("USER", "ADMIN")
				.antMatchers(HttpMethod.PUT,"/students/save/**").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE,"/students/save/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin()
				.and().httpBasic();
	}

}
