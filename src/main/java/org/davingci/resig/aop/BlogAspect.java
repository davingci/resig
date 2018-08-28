package org.davingci.resig.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BlogAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(LoginAspect.class);
	ThreadLocal<Long> timeThreadLocal = new ThreadLocal<Long>();
	
	@Pointcut("execution(* org.davingci.resig.service.impl.BlogServiceImpl.save(*))")
	public void responseLog() {		
	}
	
	@Before("responseLog()")
	public void doBefore(JoinPoint jp) {
		timeThreadLocal.set(System.currentTimeMillis());
	}
	@AfterReturning("responseLog()")
	public void doAfterReturning(JoinPoint jp) {
		try {
			logger.info("save blog use time: " + (System.currentTimeMillis() - timeThreadLocal.get()) + "ms");
			
		} catch (Throwable e){
			e.printStackTrace();
		}
	}

}
