package com.myprojects;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class HomeConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.err.println("in fogig" + http.toString());
		http.antMatcher("/**")
        .authorizeRequests().antMatchers("/logout","/login**","/callback**", "/webjars/**", "/error**").permitAll()
				.anyRequest().authenticated();
		System.err.println("in fogig");
		//http.csrf().disable();
	}

	


}
