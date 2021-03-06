
package org.davingci.resig.dao;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Integer> {

    Blog getById(Integer id);
    List<Blog> findAll();
    List<Blog> findByUser(User user);  
    List<Blog> findByUserOrderByLastModifiedDateDesc(User user);
    

}
