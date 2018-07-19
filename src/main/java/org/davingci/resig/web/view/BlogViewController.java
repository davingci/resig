
package org.davingci.resig.web.view;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogViewController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable String id, ModelMap map) {
        Blog blog = blogService.getById(Integer.valueOf(id));
        map.addAttribute("blog",blog);
        return "blog";
    }
}
