package com.nexwon.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//web.ignoring().antMatchers("/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/**").authenticated();
		

		http.formLogin()
				// 로그인 처리 페이지 : 지난 강의에선 /login 이였지만
				// 이번엔 직접 작성한 뷰를 보여줄 것이기 때문에 사용자에게
				// login 이라는 화면을 보여주는게 더 깔끔할 것 같아서 교체함!
				.loginProcessingUrl("/loginProcessing")
				// 로그인 페이지
				.loginPage("/login")
				// 로그인 실패 페이지
				.failureUrl("/login?error");

		http.logout()
				// /logout 을 호출할 경우 로그아웃
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// 로그아웃이 성공했을 경우 이동할 페이지
				.logoutSuccessUrl("/");
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/admin").permitAll();*/
		
	}

}
