
package org.davingci.resig.service;

import org.davingci.resig.domain.Comment;

public interface CommentService {

    public Comment getById(Integer id);

    public Comment save(Comment comment);

    public void update(Comment comment);
}
