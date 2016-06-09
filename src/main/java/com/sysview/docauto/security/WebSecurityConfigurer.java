package com.sysview.docauto.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	 DataSource dataSource;
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select USUARIOPROPIO, USUARIOPROPIOPASSWORD enabled from USUARIOPROPIO where USUARIOPROPIO=?");
	 }*/ 
   
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeRequests()
//                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
   }
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
     .anyRequest().permitAll()
     .and()
       .formLogin().loginPage("/login")
       .usernameParameter("username").passwordParameter("password")
     .and()
       .logout().logoutSuccessUrl("/login?logout") 
      .and()
      .exceptionHandling().accessDeniedPage("/403")
     .and()
       .csrf();
    }*/

}
