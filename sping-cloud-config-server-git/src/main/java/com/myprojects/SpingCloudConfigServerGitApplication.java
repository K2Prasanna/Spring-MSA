package com.myprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableConfigServer
public class SpingCloudConfigServerGitApplication {
	
	   @Bean
	    public WebSecurityConfigurerAdapter configurationServerWebSecurity(final ServerProperties serverProperties) {
	        return new WebSecurityConfigurerAdapter() {
	            @Override
	            protected void configure(final HttpSecurity http) throws Exception {
	                super.configure(http);
	                String path = serverProperties.getServlet().getContextPath();
	                http.authorizeRequests().antMatchers(path + "/decrypt/**").authenticated().and().csrf().disable();
	                http.authorizeRequests().antMatchers(path + "/encrypt/**").authenticated().and().csrf().disable();
	            }
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(SpingCloudConfigServerGitApplication.class, args);
	}
}
