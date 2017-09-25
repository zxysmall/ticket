package com.yy.ticket.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.core.bean.UserInfo;
import com.yy.core.service.UserInfoService;
import com.yy.core.util.StringUtil;
import com.yy.ticket.bean.UserInfoDetail;
import com.yy.ticket.mapper.UserInfoDetailMapper;
import com.yy.ticket.service.UserInfoDetailService;
import com.yy.ticket.vo.UserVo;

@Service
public class UserInfoDetailServiceImpl implements UserInfoDetailService {
	
	@Autowired
	private UserInfoDetailMapper userInfoDetailMapper;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public UserInfoDetail findByUserId(long uid) {
		// TODO Auto-generated method stub
		return userInfoDetailMapper.findByUserId(uid);
	}

	@Override
	public int save(UserInfoDetail uiDetail) {
		// TODO Auto-generated method stub
		return userInfoDetailMapper.save(uiDetail);
	}
	
	@Override
	@Transactional(rollbackOn=Exception.class)
	public int update(UserVo uvo) {
		// TODO Auto-generated method stub
		UserInfo ui = uvo.getUserInfo();
		UserInfoDetail uid = uvo.getUserInfoDetail();
		if(!StringUtil.isBlank(uvo.getNewpassword())&&
				!StringUtil.isBlank(uvo.getCheckpassword())&&
				uvo.getNewpassword().equals(uvo.getCheckpassword())){
			ui.setPassword(uvo.getNewpassword());
			userInfoService.update(ui);
		}
		int num = 0;
		uid.setUserId(ui.getUid());
		if(null != userInfoDetailMapper.findByUserId(ui.getUid()))
			num = userInfoDetailMapper.update(uid);
		else
			num = save(uid);
		return num;
	}

}
