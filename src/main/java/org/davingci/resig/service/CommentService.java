
package org.davingci.resig.service;

import java.util.List;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;

public interface CommentService {

    public Comment getById(Integer id);
    
    public List<Comment> getByBlog(Blog blog);

    public Comment save(Comment comment);

    public void update(Comment comment);
}
