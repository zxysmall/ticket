package com.yy.ticket.mapper;

import com.yy.ticket.bean.UserInfoDetail;

public interface UserInfoDetailMapper {
	/**
	 * 根据uid查询用户信息
	 * @return
	 */
	public UserInfoDetail findByUserId(long uid);
	
	/**
	 * 保存用户信息
	 * @param uiDetail
	 * @return
	 */
	public int save(UserInfoDetail uiDetail);
	
	/**
	 * 修改用户信息
	 * @param uiDetail
	 * @return
	 */
	public int update(UserInfoDetail uiDetail);
}
