package com.yy.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yy.core.bean.UserInfo;
import com.yy.core.service.UserInfoService;

public class UserInfoServiceTest extends BaseTest {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**通过username查找用户信息;*/
	@Test
	public void findByUsername(){
		UserInfo ui = userInfoService.findByUsername("zxy");
		LOGGER.info("UserInfo:{}",ui);
	};
	
	/**通过id查找用户信息;*/
	@Test
	public void findById()
	{
		UserInfo ui = userInfoService.findById(2);
		LOGGER.info("UserInfo:{}",ui);
	}
	
	/**添加用户信息*/
	@Test
	public void save()
	{
		UserInfo ui = new UserInfo();
		ui.setName("云工作室");
		ui.setUsername("yy");
		ui.setPassword("yy123");
		UserInfo _ui = userInfoService.save(ui);
		LOGGER.info("UserInfo:{}",_ui);
	}
	
	/**添加用户信息*/
	@Test
	public void update()
	{
		UserInfo ui = new UserInfo();
		ui.setUid(3);
		ui.setName("云工作室2");
		ui.setUsername("yy2");
		ui.setPassword("yy1234");
		UserInfo _ui = userInfoService.update(ui);
		LOGGER.info("UserInfo:{}",_ui);
	}
}
