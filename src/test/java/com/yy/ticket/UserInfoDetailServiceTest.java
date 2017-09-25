package com.yy.ticket;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.yy.core.BaseTest;
import com.yy.ticket.bean.UserInfoDetail;
import com.yy.ticket.service.UserInfoDetailService;
import com.yy.ticket.vo.UserVo;

public class UserInfoDetailServiceTest extends BaseTest {
	
	@Autowired
	private UserInfoDetailService service;
	
	/**
	 * 根据uid查询用户信息
	 * @return
	 */
	@Test
	public void findByUserId(){
		UserInfoDetail ud = service.findByUserId(1);
		LOGGER.info("UserInfoDetail:{}",JSON.toJSONString(ud));
	};
	
	/**
	 * 保存用户信息
	 * @param uiDetail
	 * @return
	 */
	@Test
	public void save()
	{
		UserInfoDetail ud = new UserInfoDetail();
		ud.setUserId(2L);
		ud.setGender("woman");
		ud.setEmail("111@qq.com");
		ud.setContactNumber("111");
		ud.setMobilePhone(1231231L);
		ud.setQq(111L);
		ud.setCreateUserid(1L);
		int i = service.save(ud);
		LOGGER.info("save:{}",i);
	};
	
	/**
	 * 修改用户信息
	 * @param uiDetail
	 * @return
	 */
	@Test
	public void update()
	{
		UserVo uvo = new UserVo();
		UserInfoDetail ud = new UserInfoDetail();
		ud.setUserId(2L);
		ud.setGender("male");
		ud.setEmail("1112@qq.com");
		ud.setContactNumber("1112");
		ud.setMobilePhone(12312312L);
		ud.setQq(1112L);
		ud.setUpdateUserid(1L);
		uvo.setUserInfoDetail(ud);
		int i = service.update(uvo);
		LOGGER.info("save:{}",i);
	};
}
