package com.yy.core.service;

import com.yy.core.bean.UserInfo;

public interface UserInfoService {
	
	/**通过username查找用户信息;*/
	public UserInfo findByUsername(String username);
	
	/**通过id查找用户信息;*/
	public UserInfo findById(long id);
	
	/**添加用户信息*/
	public UserInfo save(UserInfo userInfo);
	
	/**添加用户信息*/
	public UserInfo update(UserInfo userInfo);
	
}
