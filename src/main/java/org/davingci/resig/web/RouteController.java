
package org.davingci.resig.web;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.User;
import org.davingci.resig.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    @Autowired
    BlogService blogService;

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

    @GetMapping("/admin/blog/addBlog")
    public String adminAddBlog() {
        
    	return "admin/blog/addBlog";
    }
    
    @GetMapping("/admin/blog/listBlog")
    public String adminListBlog(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        List<Blog> userBlogList = blogService.getByUser(user);

        map.addAttribute("userBlogList", userBlogList);
    	return "admin/blog/listBlog";
    }
    
    @GetMapping("/blog/{id}/edit")
    public String editBlog(@PathVariable("id") String id, ModelMap map) {
    	Blog blog = blogService.getById(Integer.parseInt(id));
    	map.addAttribute("blog", blog);
    	return "admin/blog/editBlog";
    }



}
