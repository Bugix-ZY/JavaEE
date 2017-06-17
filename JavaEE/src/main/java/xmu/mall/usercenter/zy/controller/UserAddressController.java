package xmu.mall.usercenter.zy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Address;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xmu.mall.usercenter.zy.model.Region;
import xmu.mall.usercenter.zy.model.UserAddress;
import xmu.mall.usercenter.zy.service.IRegionService;
import xmu.mall.usercenter.zy.service.IUserAddressService;

@Controller
@RequestMapping(value="/user/address")
public class UserAddressController {
	
	@Autowired
	private IUserAddressService userAddressService;
	
	@Autowired
	private IRegionService regionService;

	/**
	 * 查看所有地址
	 */
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String showAddress (Model model, HttpSession session)
	{
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		List<UserAddress> addresses = userAddressService.getAddressByID(userid);
		for (int i = 0; i < addresses.size(); i++) {
			if(addresses.get(i).getIs_default() == 1){
				addresses.add(0, addresses.get(i));
				addresses.remove(i + 1);
			}
		}
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
	
	/**
	 * 跳转到增加新地址页面
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddAddress (
			Model model,
			HttpSession session)
	{
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		List<Region> province = regionService.getRegionListByParentId(1);
		model.addAttribute("provincelist",province);
		return "zy/usernewaddress";
	}
	
	/**
	 * 增加新地址 重定向
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addAddress (
			HttpServletRequest request,
			HttpSession session)
	{
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		UserAddress address = new UserAddress();
		address.setUser_id(userid);
		address.setConsignee(request.getParameter("username").toString());
		address.setTelephone(request.getParameter("telephone").toString());
		address.setZipcode(request.getParameter("zipcode").toString());
		address.setDetail(request.getParameter("details").toString());
		address.setCountry(1);
		address.setIs_default(0);
		String province = request.getParameter("province.region_id");
		String city = request.getParameter("city.region_id");
		String district = request.getParameter("district.region_id");
		address.setProvince(Integer.parseInt(province));
		address.setCity(Integer.parseInt(city));
		address.setDistrict(Integer.parseInt(district));
		// 增加地址
		System.out.println(address);
		userAddressService.addAddress(address);
		return "redirect:/user/address/all";
	}
	
	
	/**
	 * ajax刷新地址下拉框
	 * @param region_id
	 * @return	List<Region>
	 */
	@RequestMapping(value="/getsubRegionList",method=RequestMethod.POST)
	@ResponseBody
	public List<Region> getcities(int region_id)
	{
		return regionService.getRegionListByParentId(region_id);
	}
	
	/**
	 *  设置默认地址
	 */
	@RequestMapping(value="/setdefault",method=RequestMethod.POST)
	@ResponseBody
	public void setDefault (
			HttpServletRequest request,
			HttpSession session)
	{
		long userid = Long.valueOf(session.getAttribute("userId").toString());
		long addressid = Long.valueOf(request.getParameter("addressid").toString());
		System.out.println("设置默认地址");
		userAddressService.setDefaultAddress(userid, addressid);
	}
	
}
