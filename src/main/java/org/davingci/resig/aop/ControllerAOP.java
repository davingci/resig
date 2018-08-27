package org.davingci.resig.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.davingci.resig.response.Response;
import org.slf4j.LoggerFactory;

@Aspect
public class ControllerAOP {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ControllerAOP.class);
	
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		
		Response response = null;
		
		try {
			response = (Response) pjp.proceed();
			logger.info(pjp.getSignature() + "use time: " + (System.currentTimeMillis() - startTime));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return response;
	}

}
