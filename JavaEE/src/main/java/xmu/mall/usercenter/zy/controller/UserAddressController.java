package xmu.mall.usercenter.zy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mall.usercenter.zy.model.UserAddress;
import xmu.mall.usercenter.zy.service.IUserAddressService;

@Controller
@RequestMapping(value="/user/address")
public class UserAddressController {
	
	@Autowired
	private IUserAddressService userAddressService;

	/**
	 * 查看所有地址
	 */
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String showAddress (Model model, HttpSession session)
	{
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		List<UserAddress> addresses = userAddressService.getAddressByID(userid);
		model.addAttribute("addresses", addresses);
		return "zy/useraddress";
	}
	
	/**
	 * 删除地址
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public void deleteAddress (
			HttpServletRequest request,
			HttpSession session)
	{
		long addressid = Long.valueOf(request.getParameter("addressid").toString());
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		userAddressService.deleteAddress(addressid);
	}
}
