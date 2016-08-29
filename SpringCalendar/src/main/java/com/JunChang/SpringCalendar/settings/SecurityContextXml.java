package com.JunChang.SpringCalendar.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityContextXml extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/login**").anonymous()
                .antMatchers("/register**").anonymous()
                .and()
            .formLogin()
                .loginPage("/login").permitAll(false)
                .usernameParameter("login_email").passwordParameter("login_password")
                .loginProcessingUrl("/login-request")
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);        
        	/*.rememberMe()
		        .rememberMeParameter("login_rememberme")
		        .tokenRepository(getPersistentTokenRepository())
		        .tokenValiditySeconds(1209600);*/

    }
	
	@Bean
    public PersistentTokenRepository getPersistentTokenRepository(){
        InMemoryTokenRepositoryImpl repository = new InMemoryTokenRepositoryImpl();
        return repository;
    }
}
