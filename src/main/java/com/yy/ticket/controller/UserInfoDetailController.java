package com.yy.ticket.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yy.core.util.StringUtil;
import com.yy.ticket.service.UserInfoDetailService;
import com.yy.ticket.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserInfoDetailController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(BusiTicketOrderController.class);

	@Autowired
	private UserInfoDetailService userInfoDetailService;
	
	/**
	 * 修改用户信息
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(UserVo userVo){
		String result = "/updateUserInfo";
		int i = userInfoDetailService.update(userVo);
		if(i > 0&&!StringUtil.isBlank(userVo.getNewpassword())&&
				!StringUtil.isBlank(userVo.getCheckpassword())&&
				userVo.getNewpassword().equals(userVo.getCheckpassword()))
		{
			Subject subject = SecurityUtils.getSubject();  
			if (subject.isAuthenticated()) {  
		        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
		        LOGGER.debug("用户" + subject.getPrincipal() + "退出登录");  
		        result = "redirect:/login";
		    }  
		}
		else if(i > 0)
			result = "redirect:/index";
		else{
			userVo.setMsg("修改失败");
		}
		return result;
	};
	/**
	 * 修改用户信息
	 * @param userVo
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(UserVo userVo){
		String result = "redirect:/updateUserInfo";
		int i = userInfoDetailService.update(userVo);
		if(i > 0)
			result = "redirect:/index";
		else{
			result = "redirect:/addUserInfo?msg=modify error";
		}
		return result;
	};
	
}
