
package org.davingci.resig.web;

import lombok.extern.log4j.Log4j;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;
import org.davingci.resig.response.Response;
import org.davingci.resig.service.BlogService;
import org.davingci.resig.service.CommentService;
import org.davingci.resig.service.UserService;
import org.davingci.resig.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Log4j
public class CommentController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public Response add(@RequestParam String username,
                        @RequestParam String blogId,
                        @RequestParam String content,
                        @RequestParam String parentId) {
        User user = userService.findByUsername(username);
        Blog blog = blogService.getById(Integer.valueOf(blogId));
        Comment comment = Comment.builder().user(user).blog(blog).content(content).build();
        if(!parentId.equals("null")) {
            Comment parentComment = commentService.getById(Integer.valueOf(parentId));
            comment.setParentComment(parentComment);
        }
        Comment c = commentService.save(comment);

        CommentVO commentVO = CommentVO.builder()
                .content(content)
                .created(c.getCreatedDate())
                .createdByCurrentUser(Boolean.TRUE)
                .fullname(username)
                .id(c.getId().toString())
                .modified(c.getLastModifiedDate())
                .profilePictureUrl(user.getProfilePictureUrl())
                .upvoteCount(0)
                .userHasUpvoted(Boolean.FALSE)
                .build();

        Integer parent = parentId.equals("null") ? null : c.getParentComment().getId();
        commentVO.setParent(parent);

        return Response.builder().code(200).message("success").data(commentVO).build();
    }

    @PostMapping("/comment/upvote")
    public Response upvote(@RequestParam String commentId,
                           @RequestParam String username,
                           @RequestParam Boolean upvote) {
        log.info("comment upvote: username: " + username + "commentId: " + commentId + "upvote: " + upvote);
        User user = userService.findByUsername(username);
        Comment comment = commentService.getById(Integer.valueOf(commentId));
        if (upvote) {
            Set<User> users = comment.getUpVoteUsers();
            users.add(user);
        }
        else {
            Set<User> users = comment.getUpVoteUsers();
            users.remove(user);
        }
        commentService.update(comment);
        return Response.builder().code(200).build();
    }
}
