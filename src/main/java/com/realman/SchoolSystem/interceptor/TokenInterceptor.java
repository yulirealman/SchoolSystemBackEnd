package com.realman.SchoolSystem.interceptor;

import com.realman.SchoolSystem.utils.CurrentHolder;
import com.realman.SchoolSystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");

        //if token is null or empty, return 401
        if(token == null || token.isEmpty()){
            response.setStatus(401);
            return false;
        }

        //if token exsits we need to check if it's valid
        try{
            Claims claims = JwtUtils.parseToken(token);

            CurrentHolder.setCurrentId(claims.get("id", Integer.class));

        } catch (Exception e){
            response.setStatus(401);
            return false;
        }


        return true;


    }
}
