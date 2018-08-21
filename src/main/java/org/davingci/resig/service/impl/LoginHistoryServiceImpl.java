package org.davingci.resig.service.impl;

import java.util.List;

import org.davingci.resig.dao.LoginHistoryDao;
import org.davingci.resig.domain.LoginHistory;
import org.davingci.resig.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginHistoryServiceImpl implements LoginHistoryService {
	
	@Autowired
	LoginHistoryDao loginHistoryDao;
	
	@Override
	public void save(LoginHistory loginHistory) {
		loginHistoryDao.save(loginHistory);
	}
	
	@Override
	public List<LoginHistory> findByUsername(String username) {
		return loginHistoryDao.getByUsername(username);
	}

}
