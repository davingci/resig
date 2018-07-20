
package org.davingci.resig.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.BlogService;
import org.davingci.resig.service.CommentService;
import org.davingci.resig.vo.BlogCommentVO;
import org.davingci.resig.vo.CommentUserVO;
import org.davingci.resig.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;
    
    @Autowired
    CommentService commentService;

    @PostMapping("/blog/add")
    public Response addBlog(@RequestParam String title,
                            @RequestParam String html,
                            @RequestParam String text,
                            @RequestParam String abstractContent,
                            @RequestParam String thumbnailUrl) {
        Blog blog = Blog.builder().title(title).html(html).text(text)
                .abstractContent(abstractContent).thumbnailUrl(thumbnailUrl).build();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipals().getPrimaryPrincipal();
        blog.setUser(user);
        blogService.save(blog);
        return Response.builder().code(200).message("添加成功").build();
    }

    @GetMapping("/blog/{id}/comments")
    public Response getComments(@PathVariable String id) {
        Blog blog = blogService.getById(Integer.valueOf(id));
        Set<CommentVO> commentVOs = new HashSet<>();
        Set<CommentUserVO> userVOs = new HashSet<>();

        Set<Comment> comments = blog.getComments();
        comments.stream().forEach( comment -> {
            CommentVO cvo = CommentVO.build(comment);
            commentVOs.add(cvo);
            CommentUserVO cuvo = CommentUserVO.build(comment);
            userVOs.add(cuvo);
        });
        BlogCommentVO data = BlogCommentVO.builder().users(userVOs).comments(commentVOs).build();
        return Response.builder().code(200).data(data).build();

    }
    
    @PostMapping("/blog/{id}/edit")
    public Response getBlog(@PathVariable("id") Integer id, @RequestParam String title,
            @RequestParam String html,
            @RequestParam String text,
            @RequestParam String abstractContent,
            @RequestParam String thumbnailUrl) {
    	Blog  blog = blogService.getById(id);
    	blog.setTitle(title);
    	blog.setHtml(html);
    	blog.setText(text);
    	blog.setAbstractContent(abstractContent);
    	blog.setThumbnailUrl(thumbnailUrl);
    	blogService.save(blog);
      	return Response.builder().code(200).data(blog).message("edit success").build();
    }
    
    @PostMapping("/blog/{id}/delete")
    public Response delBlog(@PathVariable("id") Integer id) {
    	if (blogService.getById(id) == null) {
    		return Response.builder().code(202).build();
    	}

    	blogService.deleteById(id);
    	return Response.builder().code(200).message("delete success").build();
    }

    
}