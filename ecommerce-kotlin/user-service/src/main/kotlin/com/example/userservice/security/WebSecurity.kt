package com.example.userservice.security

import com.example.userservice.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurity(
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
            .antMatchers("/**")
            .access("hasIpAddress('192.168.45.0/24') or hasIpAddress('172.20.10.0/24') or hasIpAddress('localhost') or hasIpAddress('127.0.0.1')")
            .and()
            .addFilter(getAuthenticationFilter())

        http.headers().frameOptions().disable()
    }

    fun getAuthenticationFilter(): AuthenticationFilter {
        val authenticationFilter = AuthenticationFilter()
        authenticationFilter.setAuthenticationManager(authenticationManager())
        return authenticationFilter
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder)
    }
}