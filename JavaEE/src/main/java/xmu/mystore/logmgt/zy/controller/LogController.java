package xmu.mystore.logmgt.zy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mystore.logmgt.zy.model.Log;
import xmu.mystore.logmgt.zy.service.ILogService;


@Controller
@RequestMapping(value="log/")
public class LogController {

	@Autowired
	@Qualifier("logService")
	private ILogService logService;
	
	/* 显示全部日志记录*/
	@RequestMapping(value="all", method=RequestMethod.GET)
	public String showAllLog(Model model)
	{
		List<Log> logs = logService.getAllLog();
		model.addAttribute("logs",logs); 
		return "zy/logall";
	}
	
	/* 根据时间查询日志记录 */
	@RequestMapping(value="result",method=RequestMethod.POST)
	public String added(@RequestParam(value="start")String start, @RequestParam(value="end")String end,Model model)
	{
		System.out.println(start);
		System.out.println(end);
		Date sdate = null, edate = null;
		List<Log> logs = new ArrayList<Log>(0);
		SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			if(!start.isEmpty() && !end.isEmpty() ){ // 开始时间到结束时间之间的所有日志记录 
				logs = logService.getLogByTime(format.parse(start).getTime(), format.parse(end).getTime());
			} else if(!start.isEmpty() && end.isEmpty() ) { // 开始时间往后的所有日志记录
				logs = logService.getLogByTime(format.parse(start).getTime(), Long.MAX_VALUE);
			} else if (start.isEmpty() && !end.isEmpty() ) { // 结束日期往前的所有日志记录
				logs = logService.getLogByTime(0, format.parse(end).getTime());
			} else { // 如果没有指定任何时间，那么显示所有日志记录
				logs = logService.getAllLog();	
			}
		} catch (ParseException e) {
			
		}		
	    model.addAttribute("logs", logs);
		return "zy/logresultbytime";
	}
	
	/* 跳转至精准查询页面 */
	@RequestMapping(value="time",method=RequestMethod.GET)
	public String search(Model model)
	{
		return "zy/logsearchbytime";
	}
}
