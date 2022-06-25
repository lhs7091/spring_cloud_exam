package com.example.userservice.security

import com.example.userservice.dto.RequestLogin
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter: UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        try {
            val requestLogin = ObjectMapper().readValue(request.inputStream, RequestLogin::class.java)
            return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    requestLogin.email,
                    requestLogin.password
                )
            )
        }catch (e: IOException){
            throw RuntimeException(e)
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val principal = authResult.principal
        ObjectMapper().writeValue(response.outputStream, principal)
    }
}