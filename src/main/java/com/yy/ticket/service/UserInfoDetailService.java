package com.yy.ticket.service;

import com.yy.ticket.bean.UserInfoDetail;
import com.yy.ticket.vo.UserVo;

public interface UserInfoDetailService {
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
	 * @param uvo
	 * @return
	 */
	public int update(UserVo uvo);
}
