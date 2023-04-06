//package com.graph.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//
//@Configuration
//@EnableWebFluxSecurity
//public class SpringWebfluxSecurityConfig {
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http
//			.authorizeExchange(exchanges -> exchanges
//			    .anyExchange().authenticated()
//			)
//			.httpBasic().and().formLogin();
//		
//		http.csrf().disable();
//		  
//		return http.build();
//	}
//	
//	
//	@Bean
//	 MapReactiveUserDetailsService userDetails()
//	 {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				               .username("suman").password("12345")
//				               .roles("USER").build();
//		 UserDetails user1 = User.withDefaultPasswordEncoder()
//	               .username("ghorai").password("12345")
//	               .roles("ADMIN").build();
//		   return new MapReactiveUserDetailsService(user,user1);
//		
//	 }
//	
//	
//	
//	
//	
//	
//
//}
