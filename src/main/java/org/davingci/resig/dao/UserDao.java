
package org.davingci.resig.dao;

import java.util.List;

import org.davingci.resig.domain.Comment;
import org.davingci.resig.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    public User findByUsername(String username);    
   
}
