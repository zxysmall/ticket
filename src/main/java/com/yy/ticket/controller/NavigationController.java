package com.yy.ticket.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.core.bean.UserInfo;
import com.yy.ticket.bean.UserInfoDetail;
import com.yy.ticket.service.UserInfoDetailService;

@Controller
public class NavigationController {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(NavigationController.class);
	
	 @Autowired
	protected HttpServletRequest request;
		
	@Autowired
	private UserInfoDetailService userInfoDetailService;
	
	@RequestMapping("/alreadyExistsOrder")
	public String alreadyExistsOrder()
	{
//		Subject sb =  SecurityUtils.getSubject();
//		LOGGER.info("principal:{}",sb.getPrincipal());
//		UserInfo ui = (UserInfo) sb.getPrincipal();
		request.setAttribute("menu", "alreadyExistsOrder");
		return "alreadyExistsOrder";
	}
	
	@RequestMapping("/allOrder")
	public String allOrder()
	{
		request.setAttribute("menu", "allOrder");
		return "index";
	}
	
	@RequestMapping("/addOrderInfo")
	public String addOrderInfo()
	{
		request.setAttribute("menu", "addOrderInfo");
		return "addOrderInfo";
	}
	
	@RequestMapping("/statistics")
	public String statistics() 
	{
		request.setAttribute("menu", "statistics");
		return "statistics";
	}
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(Map<String,Object> map) 
	{
		request.setAttribute("menu", "updateUserInfo");
		String msg = request.getParameter("msg"); 
		Subject sb =  SecurityUtils.getSubject();
		LOGGER.info("principal:{}",sb.getPrincipal());
		UserInfo ui = (UserInfo) sb.getPrincipal();
		UserInfoDetail uid =  userInfoDetailService.findByUserId(ui.getUid());
		if(uid == null)
		{
			uid = new UserInfoDetail();
			uid.setUserId(ui.getUid());
		}
		map.put("userInfoDetail", uid);
		map.put("userInfo", ui);
		map.put("msg", msg);
		return "updateUserInfo";
	}
	
	@RequestMapping("/addUserInfo")
	public String addUserInfo(Map<String,Object> map) {
		request.setAttribute("menu", "addUserInfo");
		String msg = request.getParameter("msg"); 
		map.put("msg", msg);
		return "addUserInfo";
	}
}
