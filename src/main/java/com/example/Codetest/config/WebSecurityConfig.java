package com.example.Codetest.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	  private JwtTokenProvider jwtTokenProvider;

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {

	    // Disable CSRF (cross site request forgery)
	    http.csrf().disable();

	    // No session will be created or used by spring security
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    // Entry points
	    http.authorizeRequests()//
	        .antMatchers("/login").permitAll()
	        .antMatchers("/signup").permitAll()
	        // Disallow everything else..
	        .anyRequest().authenticated();

	    // If a user try to access a resource without having enough permissions
	    http.exceptionHandling().accessDeniedPage("/login");

	    // Apply JWT
	    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

	    // Optional, if you want to test the API from a browser
	     http.httpBasic();
	  }

	  @Override
	  public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/v2/api-docs")//
	        .antMatchers("/configuration/**")//
	        .antMatchers("/webjars/**")//
	        .antMatchers("/public")
	        .antMatchers("/resources/**")
	        
	        // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
	        .and()
	        .ignoring()
	        .antMatchers("/h2-console/**/**");;
	  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public AuthenticationManager getAuthenticationManager()throws Exception {
	  return super.authenticationManagerBean();
  }
  
  @Bean
  public CommonsMultipartResolver multipartResolver() {
      return new CommonsMultipartResolver();
  }

}
