
package org.davingci.resig.service;

import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogService {
	
	public void save(Blog blog);

    public Blog saveAndFlush(Blog blog);
        
    public List<Blog> list();

    public Blog getById(Integer id);
    
    public void deleteById(Integer id);
    
    public List<Blog> getByUser(User user);
    
    public List<Blog> getByUserSortByLastModifiedDateDesc(User user);
    
    public void hitCounter(Integer id);

}
