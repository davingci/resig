
package org.davingci.resig.service.impl;

import java.util.List;

import org.davingci.resig.dao.CommentDao;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment getById(Integer id) {
        return commentDao.getOne(id);
    }
    
    @Override
    public List<Comment> getByBlog(Blog blog){
    	return commentDao.findByBlog(blog);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentDao.saveAndFlush(comment);
    }
}
