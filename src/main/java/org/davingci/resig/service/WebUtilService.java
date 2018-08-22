package org.davingci.resig.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public interface WebUtilService {
	
	 public Map<String, String> getRquestHeadersInMap(HttpServletRequest request);
	 
	 public String getClientIp(HttpServletRequest request);

}
