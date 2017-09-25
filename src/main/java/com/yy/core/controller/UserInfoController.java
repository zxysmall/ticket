package com.yy.core.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.core.bean.UserInfo;
import com.yy.core.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	
	/**
	 * 用户查询.
	 * @return
	 */
	@RequestMapping("/userList")
	public String userInfo(){
		return "userInfo";
	}
	
	/**
	 * 用户添加;
	 * @return
	 */
	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add")//权限管理;
	public String userInfoAdd(Map<String,Object> map,UserInfo userInfo){
		userInfo = userInfoService.findByUsername("admin");
		map.put("userInfo", userInfo);
		return "userInfoAdd";
	}
	
	/**
	 * 用户删除;
	 * @return
	 */
	@RequestMapping("/userDel")
	@RequiresPermissions("userInfo:del")//权限管理;
	public String userDel(){
		return "userInfoDel";
	}

}
