
package org.davingci.resig.web;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.davingci.resig.domain.LoginHistory;
import org.davingci.resig.dto.LoginReturnDTO;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.LoginHistoryService;
import org.davingci.resig.service.UserService;
import org.davingci.resig.service.WebUtilService;
import org.davingci.resig.service.impl.WebUtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Log4j
public class AuthController {
	
    @Autowired
    HttpSession httpSession;

    @Autowired
    private UserService userService;
    
    @Autowired
    private LoginHistoryService loginHistoryService;
    
    
            
    @PostMapping("/auth/login")
    public Response login(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String url,
                          @RequestParam String clientOs,
                          @RequestParam String clientOsVersion,
                          @RequestParam String clientBrowser,
                          @RequestParam String clientEngine,
                          @RequestParam String clientCpu,
                          HttpServletRequest request) {
        log.info(username + "login");
        
        //list header
        //Map<String, String> re = getRquestHeadersInMap(request); 
        //System.out.println(re);
        
        WebUtilService webUtil = new WebUtilServiceImpl();
		String loginIp = webUtil.getClientIp(request);
		
		//set location current until ipstack is used
        String loginLocation = null;
        if(loginLocation == null) {
        	loginLocation = "current";
        }
       
        //login history
        Date loginDate = Calendar.getInstance().getTime();
        LoginHistory loginHistory = LoginHistory.builder()
        									.username(username)
        									.loginIp(loginIp)
        									.loginLocation(loginLocation)
        									.loginDate(loginDate)
        									.clientOs(clientOsVersion)
        									.clientOsVersion(clientOsVersion)
        									.clientBrowser(clientBrowser)
        									.clientEngine(clientEngine)
        									.clientCpu(clientCpu)
        									.build();
        loginHistoryService.save(loginHistory);
        
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
