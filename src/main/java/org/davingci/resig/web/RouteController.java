
package org.davingci.resig.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteController {



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    /** admin route**/

    @GetMapping("/admin/index")
    public String adminIndex() {
        return "admin/index";
    }

    @GetMapping("/admin/blog/{page}")
    public String adminBlog(@PathVariable("page") String page) {
        return "admin/blog/" + page ;
    }


}
