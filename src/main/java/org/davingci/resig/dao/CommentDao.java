
package org.davingci.resig.dao;

import java.util.List;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Integer> {
	
	List<Comment> findByBlog(Blog blog);
}
