package com.realman.SchoolSystem.interceptor;

import com.realman.SchoolSystem.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String requestURI = request.getRequestURI(); // ie. /api/dept/1
//
//        //we don't block /login, because it needs login to have token
//        if(requestURI.contains("/login")){
//            return true;
//        }

        String token = request.getHeader("token");

        //if token is null or empty, return 401
        if(token == null || token.isEmpty()){
            response.setStatus(401);
            return false;
        }

        //if token exsits we need to check if it's valid
        try{
            JwtUtils.parseToken(token);
        } catch (Exception e){
            response.setStatus(401);
            return false;
        }


        return true;


    }
}
