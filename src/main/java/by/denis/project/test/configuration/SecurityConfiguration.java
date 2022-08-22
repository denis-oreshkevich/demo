package by.denis.project.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors()
		.and()
		.authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.oauth2Login();
		return http.build();
	}

}
