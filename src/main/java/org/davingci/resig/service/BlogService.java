
package org.davingci.resig.service;

import org.davingci.resig.domain.Blog;

import java.util.List;

public interface BlogService {

    public void save(Blog blog);

    public List<Blog> list();

    public Blog getById(Integer id);
}
