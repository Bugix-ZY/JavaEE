package com.xmu.sw.zjh.javaee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmu.sw.zjh.javaee.entity.Card;
import com.xmu.sw.zjh.javaee.entity.User;
import com.xmu.sw.zjh.javaee.service.ICardService;
import com.xmu.sw.zjh.javaee.service.IUserService;

@Controller
@RequestMapping(value="/")
public class OrderController {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{
		return "home";
	}

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String toHome(Model model)
	{
		User user = userService.getUser(2550);
		System.out.println(user);
		model.addAttribute("city","xiamen");
		return "anotherHome";
	}

}
