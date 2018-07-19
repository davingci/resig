
package org.davingci.resig.web;


import lombok.extern.log4j.Log4j;
import org.davingci.resig.domain.User;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/user/register")
    public Response register(@RequestParam String username,
                             @RequestParam String password) {
        log.info("register");
        log.debug("username" + username);
        log.debug("password" + password);
        User user = User.builder().username(username).password(password).build();
        userService.save(user);
        return Response.builder().code(200).message("register success.").build();
    }
}
