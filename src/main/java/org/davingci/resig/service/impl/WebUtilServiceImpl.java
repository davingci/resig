package org.davingci.resig.service.impl;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.davingci.resig.service.WebUtilService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class WebUtilServiceImpl implements WebUtilService{
	

	public Map<String, String> getRquestHeadersInMap(HttpServletRequest request) {
    	
    	Map<String, String> result = new HashMap<>();
    	
    	Enumeration headerNames = request.getHeaderNames();
    	while (headerNames.hasMoreElements()) {
    		String key = (String) headerNames.nextElement();
    		String value = request.getHeader(key);
    		result.put(key, value);
    	}
    	return result;
    }
	

    public String getClientIp(HttpServletRequest request) {
		String ip = "";
    	if (request != null) {		
			 ip = request.getHeader("X-Forwarded-For");  
		    if(ip == null || ip.length() == 0 || "".equals(ip)) {  
		    	ip = request.getHeader("Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "".equals(ip)) {  
		    	ip = request.getHeader("WL-Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "".equals(ip)) {  
		    	ip = request.getRemoteAddr();  
		    } 
		    
		 }	
		return ip;
    }

}
