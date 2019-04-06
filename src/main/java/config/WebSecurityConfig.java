package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import security.CustomUserDetailsService;


@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService);
 } 

 @Override
 protected void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable();
	 	
	   http.authorizeRequests()
	   .antMatchers("/createadmin", "/addgroup", "/addfiliere", "/addmatiere", "/addsalle",
			   		"/deletegroup", "/deletefiliere", "/deletematiere", "/deletesalle", "/disponibilite", "/insertemploi").access("hasRole('ROLE_ADMIN')")
	   .and()
	   .formLogin().loginPage("/login").permitAll()
	   .usernameParameter("username").passwordParameter("password")
	   .and()
	    .logout().logoutSuccessUrl("/login?logout")
	    .and()
	    .exceptionHandling().accessDeniedPage("/403");
	  
 }
 
}