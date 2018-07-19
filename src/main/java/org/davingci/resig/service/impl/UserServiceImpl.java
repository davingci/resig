
package org.davingci.resig.service.impl;

import org.davingci.resig.dao.UserDao;
import org.davingci.resig.domain.User;
import org.davingci.resig.service.UserService;
import org.davingci.resig.shiro.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        PasswordUtil.encryptPassword(user);
        userDao.save(user);
    }


}
