package xmu.mystore.logmgt.zy.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.annotation.zy.ServiceLogger;
import xmu.mystore.logmgt.zy.mapper.ILogMapper;
import xmu.mystore.logmgt.zy.model.Log;
import xmu.mystore.logmgt.zy.service.ILogService;

@Service("logService")
@Transactional
public class LogServiceImpl implements ILogService{

	@Autowired
	private ILogMapper logDao;
	
	public List<Log> getAllLog() {
		System.out.println("getAllLog");
		return logDao.getAllLog();
	}

	public List<Log> getLogByTime(long start, long end) {
		System.out.println("getLogByTime");
		return logDao.getLogByTime(start, end);
	}

	public void addLog(Log log) {
		logDao.addLog(log);
	}

}
