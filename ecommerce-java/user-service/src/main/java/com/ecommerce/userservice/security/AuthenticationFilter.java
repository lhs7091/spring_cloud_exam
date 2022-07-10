package com.ecommerce.userservice.security;

import com.ecommerce.userservice.dto.RequestLogin;
import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;
    private final Environment env;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            RequestLogin requestLogin = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestLogin.getEmail(),
                            requestLogin.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 로그인 실제 성공했을때, 토큰을 만들거나 어떤 반환값을 줄건지 처리하는 메서드
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        User principal = (User) authResult.getPrincipal();
        UserDto userDetails = userService.getUserDetailsByEmail(principal.getUsername());

        byte[] keyBytes = env.getProperty("token.secret").getBytes(StandardCharsets.UTF_8);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        String token = Jwts.builder()
                .setSubject(userDetails.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(env.getProperty("token.expiration_time"))))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", userDetails.getUserId());
    }
}
