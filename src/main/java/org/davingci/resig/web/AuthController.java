
package org.davingci.resig.web;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.davingci.resig.dto.LoginReturnDTO;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Log4j
public class AuthController {

    @Autowired
    HttpSession httpSession;

    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public Response login(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String url) {
        log.info(username + "login");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        String message = "";
        Integer code = Integer.valueOf(400);
        try {
            subject.login(token);
            httpSession.setAttribute("username",username);

        } catch(UnknownAccountException e) {
            message = "用户名或者账号错误";

        } catch(IncorrectCredentialsException e) {
            message = "用户名或者账号错误";

        } catch(Exception e) {
            message = "登录失败";

        }
        if(subject.isAuthenticated()) {
            message = "登录成功";
            code = Integer.valueOf(200);
        }
        LoginReturnDTO loginReturnDTO = LoginReturnDTO.builder().url(url).build();
        return Response.builder().message(message).code(code).data(loginReturnDTO).build();

    }

}
