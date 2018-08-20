package org.davingci.resig.service.impl;

import org.davingci.resig.dao.UserAgentDao;
import org.davingci.resig.domain.UserAgent;
import org.davingci.resig.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAgentServiceImpl implements UserAgentService{
	
	@Autowired
	UserAgentDao userAgentDao;
	
	@Override
	public void save(UserAgent userAgent) {
		userAgentDao.save(userAgent);
	}
	
	@Override
	public UserAgent findById(Integer id) {
		return userAgentDao.getById(id);
	}



}
