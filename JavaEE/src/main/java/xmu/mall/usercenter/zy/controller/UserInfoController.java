package xmu.mall.usercenter.zy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xmu.mall.usercenter.zy.model.User;
import xmu.mall.usercenter.zy.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserInfoController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value="home", method=RequestMethod.GET)
	public String toHome(){
		return "zy/userhome";
	}
	
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String userInfo(Model model, HttpSession session){
		Long userid = Long.valueOf(session.getAttribute("userId").toString());
		User user = userService.getUserByID(userid);
		model.addAttribute("user", user);
		return "zy/userinfo";
	}
	
	/*
	 *  跳转到修改用户信息页面
	 */
	@RequestMapping(value="/info/modify", method=RequestMethod.GET)
	public String toModifyUserName(Model model, HttpSession session){
		Long userid = Long.valueOf(session.getAttribute("userId").toString());
		return "zy/usermodifyname";
	}
	
	/*
	 *  修改用户信息
	 */
	@RequestMapping(value="/info/modify", method=RequestMethod.POST)
	public String ModifyUserName(@RequestParam(value="username") String username,
			Model model, HttpSession session){
		Long userid = Long.valueOf(session.getAttribute("userId").toString());
		if(username != null) {
			userService.updateUsername(userid, username);
		}
		User user = userService.getUserByID(userid);
		model.addAttribute("user", user);
		return "redirect:/user/info";
	}
	
	
	
	
}
