package org.davingci.resig.service;

import org.davingci.resig.domain.UserAgent;

public interface UserAgentService {
	public void save(UserAgent userAgent);
	public UserAgent findById(Integer id);

}
