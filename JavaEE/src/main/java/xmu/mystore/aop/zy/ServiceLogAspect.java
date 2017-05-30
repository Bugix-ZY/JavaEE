package xmu.mystore.aop.zy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xmu.mystore.logmgt.zy.model.Log;
import xmu.mystore.logmgt.zy.service.ILogService;

@Aspect
@Component
public class ServiceLogAspect {
	
	@Autowired
	private ILogService logService;
	
	@Pointcut("@annotation(xmu.mystore.annotation.zy.ServiceLogger)")
	public void servicePointcut() {
	}
	
	/**
	 * 写成功记录
	 * @param joinPoint
	 * @throws UnknownHostException
	 */
	@AfterReturning("servicePointcut()")
	public void logAfterPointcut(JoinPoint joinPoint) throws UnknownHostException {
		// 操作者 ID 【空】
        int adminID = 0;
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 当前 IP 地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
		// 当前操作的类名
		String className = joinPoint.getTarget().getClass().getSimpleName(); 
		// 当前操作的方法名
        String methodName = joinPoint.getSignature().getName();  
        // 当前操作的参数
        String content = "";
        if(joinPoint.getArgs().length > 0) {
        	try {
	        	if (joinPoint.getArgs()[0] instanceof Long || joinPoint.getArgs()[0] instanceof Integer){ // 数字转字符串
	        		content =  joinPoint.getArgs()[0].toString();	
	        	} else if (joinPoint.getArgs()[0] instanceof String){ // 字符串直接拼接
	        		content = (String) joinPoint.getArgs()[0];
	        	} else {
	        		content = joinPoint.getArgs()[0].getClass().getName(); // 类名
	        	}
        	}
        	catch (ClassCastException e){ 
        			content = "";
        	}
        }
        for (int i = 1; i < joinPoint.getArgs().length; i++) {  
            content += ",";
            try {
	        	if (joinPoint.getArgs()[0] instanceof Long || joinPoint.getArgs()[0] instanceof Integer){
	        		content =  joinPoint.getArgs()[0].toString();	
	        	} else if (joinPoint.getArgs()[0] instanceof String){
	        		content = (String) joinPoint.getArgs()[0];
	        	} else {
	        		content = joinPoint.getArgs()[0].getClass().getName(); 
	        	}
        	}
        	catch (ClassCastException e){ 
        			content = "";
        	}
        }  
       
        logService.addLog(new Log(adminID, currentTime, className, methodName, content, 1, hostAddress));
	}


	/**
	 * 写失败记录
	 * @param joinPoint
	 * @throws IOException
	 */
	@AfterThrowing("servicePointcut()")
	public void logAfterPointcutFail(JoinPoint joinPoint) throws IOException {
		// 操作者 ID
        int adminID = 0;
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 当前 IP 地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
		// 当前操作的类名
		String className = joinPoint.getTarget().getClass().getSimpleName(); 
		// 当前操作的方法名
        String methodName = joinPoint.getSignature().getName();  
        // 当前操作的参数
        String content = "";
        if(joinPoint.getArgs().length > 0) {
        	try {
	        	if (joinPoint.getArgs()[0] instanceof Long || joinPoint.getArgs()[0] instanceof Integer){
	        		content =  joinPoint.getArgs()[0].toString();	
	        	} else if (joinPoint.getArgs()[0] instanceof String){
	        		content = (String) joinPoint.getArgs()[0];
	        	} else {
	        		content = joinPoint.getArgs()[0].getClass().getName(); 
	        	}
        	}
        	catch (ClassCastException e){ 
        			content = "";
        	}
        }
        for (int i = 1; i < joinPoint.getArgs().length; i++) {  
            content += ",";
            try {
	        	if (joinPoint.getArgs()[0] instanceof Long || joinPoint.getArgs()[0] instanceof Integer){
	        		content =  joinPoint.getArgs()[0].toString();	
	        	} else if (joinPoint.getArgs()[0] instanceof String){
	        		content = (String) joinPoint.getArgs()[0];
	        	} else {
	        		content = joinPoint.getArgs()[0].getClass().getName();
	        	} 
        	}
        	catch (ClassCastException e){ 
        		content = "";
        	}
        }  
        logService.addLog(new Log(adminID, currentTime, className, methodName, content, 0, hostAddress));
	}
}
