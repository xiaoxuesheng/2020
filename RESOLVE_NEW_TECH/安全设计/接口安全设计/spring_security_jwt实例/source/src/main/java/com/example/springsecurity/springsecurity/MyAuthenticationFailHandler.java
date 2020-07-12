package 安全设计.接口安全设计.spring_security_jwt实例.source.src.main.java.com.example.springsecurity.springsecurity;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring security登录失败处理类
 *  * GYB
 *  * 20190220
 */
@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler   {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("登录失败");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write("{\"result\":\"fail\"}");
        httpServletResponse.getWriter().flush();
    }
}
