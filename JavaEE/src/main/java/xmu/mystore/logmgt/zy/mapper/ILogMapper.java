package xmu.mystore.logmgt.zy.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xmu.mystore.logmgt.zy.model.Log;


@Component
public interface ILogMapper {
	
	/*-- 查询 --*/
	List<Log> getAllLog();
	List<Log> getLogByTime(@Param("start")long start, @Param("end")long end);
	
	/*-- 增加 --*/
	void addLog(Log log);
}
