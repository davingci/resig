
package org.davingci.resig.service.impl;

import org.davingci.resig.dao.BlogDao;
import org.davingci.resig.domain.Blog;
import org.davingci.resig.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    public void save(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public List<Blog> list() {
        return blogDao.findAll();
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

}
