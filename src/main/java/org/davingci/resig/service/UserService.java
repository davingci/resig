
package org.davingci.resig.service;

import org.davingci.resig.domain.User;

public interface UserService {

    public User findByUsername(String username);

    public void save(User user);
}
