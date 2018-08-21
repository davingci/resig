package org.davingci.resig.service;

import java.util.List;

import org.davingci.resig.domain.LoginHistory;

public interface LoginHistoryService {
	
	public void save(LoginHistory loginHistory);
	public List<LoginHistory> findByUsername(String username);

}
