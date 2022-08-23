package by.denis.project.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

	public static final String INDEX = "/";
	public static final String ROLE_USER = "ROLE_USER";

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.cors()
		.and()
			.authorizeRequests().antMatchers(HttpMethod.GET, INDEX).authenticated()
		.and()
			.authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
		.and()
			.authorizeRequests().anyRequest().hasAuthority(ROLE_USER)
		.and()
			.oauth2Login();
		return http.build();
	}

}
