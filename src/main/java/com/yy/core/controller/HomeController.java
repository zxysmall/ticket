package com.yy.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yy.core.bean.UserInfo;
import com.yy.core.config.ShiroConfiguration;
import com.yy.ticket.content.BusiContent;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfiguration.class);
	
	@Autowired
	private HttpServletRequest request;

	 
	@RequestMapping({"/","/index"})
	public String index(Map<String,Object> map){
		Subject sb =  SecurityUtils.getSubject();
		LOGGER.info("principal:{}",sb.getPrincipal());
		UserInfo ui = (UserInfo) sb.getPrincipal();
		map.put("username", ui.getUsername());
		if(ui.getRoleList().size()!=0 && BusiContent.TICKET_AGENT.equals(ui.getRoleList().get(0).getRole()))
			return "/addOrderInfo";
		return "/index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	// 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Map<String, Object> map) throws Exception {
		LOGGER.info("HomeController.login()");
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) request.getAttribute("shiroLoginFailure");

		LOGGER.info("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				LOGGER.info("UnknownAccountException -- > 账号不存在：");
				msg = "账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				LOGGER.info("IncorrectCredentialsException -- > 密码不正确：");
				msg = "密码不正确";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				LOGGER.info("kaptchaValidateFailed -- > 验证码错误");
				msg = "验证码错误";
			} else {
				msg = "else >> "+exception;
				LOGGER.info("其他错误-->" + exception);
			}
			map.put("msg", msg);
			return "/login";
		}
		// 此方法不处理登录成功,由shiro进行处理.
		return "/index";
	}
	
}
