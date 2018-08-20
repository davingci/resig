
package org.davingci.resig.service.impl;

import org.davingci.resig.dao.BlogDao;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.domain.User;
import org.davingci.resig.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;
    
    @Override
    public void save(Blog blog) {
    	blogDao.save(blog);
    }

    @Override
    public Blog saveAndFlush(Blog blog) {
        return blogDao.saveAndFlush(blog);
    }

    @Override
    public List<Blog> list() {
        return blogDao.findAll().stream().filter(blog -> "APPROVED".equals(String.valueOf(blog.getBlogState()))).collect(Collectors.toList());
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }
    
    @Override
    public void deleteById(Integer id) {
    	blogDao.deleteById(id);
    }
    
    @Override
    public List<Blog> getByUser(User user){
    	return blogDao.findByUser(user);
    }
    
    @Override
    public List<Blog> getByUserSortByLastModifiedDateDesc(User user) {
    	return blogDao.findByUserOrderByLastModifiedDateDesc(user);
    }
    


}
