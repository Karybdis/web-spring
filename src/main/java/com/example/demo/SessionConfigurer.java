package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
public class SessionConfigurer extends WebMvcConfigurerAdapter
{
    @Bean
    public UserSecurityInterceptor getUserSecurityInterceptor()
    {
        return new UserSecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
       InterceptorRegistration addInterceptor = registry.addInterceptor(getUserSecurityInterceptor());
       addInterceptor.excludePathPatterns("/login","/signup","/home","/error");
       addInterceptor.addPathPatterns("/**");
    }

    public class UserSecurityInterceptor extends HandlerInterceptorAdapter
    {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
        {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") == null)
            {
                response.sendRedirect("/login");
                return false;
            }
            return true;
        }
    }
}
