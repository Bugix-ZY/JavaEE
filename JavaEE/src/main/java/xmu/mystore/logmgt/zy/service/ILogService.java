package xmu.mystore.logmgt.zy.service;

import java.util.List;
import org.springframework.stereotype.Component;

import xmu.mystore.annotation.zy.ServiceLogger;
import xmu.mystore.logmgt.zy.model.Log;

@Component
public interface ILogService {

	/*-- 查询 --*/

	public List<Log> getAllLog();
	public List<Log> getLogByTime(long start,long end);
	
	/*-- 增加 --*/
	public void addLog(Log log);
}
