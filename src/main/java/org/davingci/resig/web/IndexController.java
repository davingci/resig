
package org.davingci.resig.web;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.service.BlogService;
import org.davingci.resig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(ModelMap map) {
        List<Blog> blogs = blogService.list();
        map.addAttribute("blogs",blogs);

        return "index";
    }
}
