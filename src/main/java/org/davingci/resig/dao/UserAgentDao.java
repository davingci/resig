package org.davingci.resig.dao;

import java.util.List;

import org.davingci.resig.domain.UserAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentDao extends JpaRepository<UserAgent, Integer> {
	
	UserAgent getById(Integer id);	
	
	

}
