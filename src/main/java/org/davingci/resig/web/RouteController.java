
package org.davingci.resig.web;

import java.util.Collections;
import java.util.Comparator;
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
    	
        List<Blog> savedList = userBlogList.stream().filter(b -> "SAVED".equals(String.valueOf(b.getBlogState()))).collect(Collectors.toList());
        map.addAttribute("userBlogList", savedList);
        if (savedList.size() != 0) {
        Collections.sort(savedList, new Comparator<Blog>() {
    		public int compare(Blog b1, Blog b2) {
    			return b1.getLastModifiedDate().compareTo(b2.getLastModifiedDate());
    		}
    	});    	
    	map.addAttribute("rescentBlog", savedList.get(0));
    	}else {
    		map.addAttribute("rescentBlog", "no blog");
    	}
        return "admin/blog/listBlog";
    }
    
    @GetMapping("/admin/blog/publishedBlog")
    public String adminpublishedBlog(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        List<Blog> userBlogList = blogService.getByUser(user);
        userBlogList.forEach(b -> System.out.println(String.valueOf(b.getBlogState())));
        map.addAttribute("userPublishedBlogList", userBlogList.stream().filter(b -> "APPROVED".equals(String.valueOf(b.getBlogState()))).collect(Collectors.toList()));
    	return "admin/blog/publishedBlog";
    }
    
    @GetMapping("/admin/blog/listTrashBlog")
    public String adminListTrashBlog(ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        List<Blog> userBlogList = blogService.getByUser(user);
        userBlogList.forEach(b -> System.out.println(String.valueOf(b.getBlogState())));
        map.addAttribute("userTrashBlogList", userBlogList.stream().filter(b -> "DELETED".equals(String.valueOf(b.getBlogState()))).collect(Collectors.toList()));
    	return "admin/blog/listTrashBlog";
    }
    
    
    @GetMapping("/blog/{id}/edit")
    public String editBlog(@PathVariable("id") String id, ModelMap map) {
    	Blog blog = blogService.getById(Integer.parseInt(id));
    	map.addAttribute("blog", blog);
    	return "admin/blog/editBlog";
    }



}
