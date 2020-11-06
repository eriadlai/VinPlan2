package com.narval.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.narval.Services.MyUserDetailsService;
import com.narval.config.SuccesHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private final AuthenticationSuccessHandler authenticationSuccessHandler;

	@Bean
	public UserDetailsService userDetailsService() {
		  return new MyUserDetailsService();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
	         
		return authProvider;
	}
	
	@Autowired
    public WebSecurityConfiguration(SuccesHandler myAuthenticationSuccesHandler ) {
        this.authenticationSuccessHandler = myAuthenticationSuccesHandler;
    }
    
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService());
    }
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/login").permitAll()
    	.antMatchers(HttpMethod.POST,"/MainMenu").permitAll()
    	.antMatchers("/css/*").permitAll()
    	.antMatchers("/img/*").permitAll()
    	.antMatchers("/static/").permitAll()
    	.antMatchers("/templates").permitAll()
    	.antMatchers("/SignUp").permitAll()
    	.anyRequest().authenticated()
    	.and()
    	.formLogin().permitAll()
    	.loginPage("/login")
    		.successForwardUrl("/MainMenu")
    	.and()
    	.logout().permitAll();
  
    
       
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(31);
    }
}
