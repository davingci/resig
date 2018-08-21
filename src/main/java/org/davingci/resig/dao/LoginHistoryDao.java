package org.davingci.resig.dao;

import java.util.List;

import org.davingci.resig.domain.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryDao extends JpaRepository<LoginHistory, Integer> {
	
	public List<LoginHistory> getByUsername(String username);

}
