package org.davingci.resig.dao;

import org.davingci.resig.domain.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryDao extends JpaRepository<LoginHistory, Integer> {
	
	public LoginHistory findByUsername(String username);

}
