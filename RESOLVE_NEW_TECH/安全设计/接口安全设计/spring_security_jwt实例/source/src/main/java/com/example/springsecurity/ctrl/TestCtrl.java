package 安全设计.接口安全设计.spring_security_jwt实例.source.src.main.java.com.example.springsecurity.ctrl;

import com.example.springsecurity.springsecurity.JwtUser;
import com.example.springsecurity.springsecurity.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestCtrl {

    @GetMapping("aaa")
    public String aaa(){
        //获取当前登录用户
        JwtUser jwtUser  = JwtUser.getCurUser();
        System.out.println(jwtUser);
        return "sucess.........";
    }

    @PostMapping("parseJWT")
    public String login(String jwt){
        Claims Claims = JwtUtils.parseJWT(jwt);
        return Claims.getId();
    }

    @RequestMapping("/error")
    public void error(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            response.getWriter().write("{\"result\":\"error\"}");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
