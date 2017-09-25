package com.yy.core.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yy.core.bean.UserInfo;
import com.yy.core.repository.UserInfoRepository;
import com.yy.core.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	
	@Resource
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfo findByUsername(String username) {
		LOGGER.info("UserInfoServiceImpl.findByUsername()");
		return userInfoRepository.findByUsername(username);
	}
	
	@Override
	public UserInfo findById(long id) {
		// TODO Auto-generated method stub
		LOGGER.info("UserInfoServiceImpl.findById()");
		return userInfoRepository.findOne(id);
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public UserInfo save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		LOGGER.info("UserInfoServiceImpl.save()");
		//加密算法
		String algorithmName = "md5";  
		String username = userInfo.getUsername();  
		String password = userInfo.getPassword();  
		//私盐
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();  
		//加密几次
		int hashIterations = 2;  
		SimpleHash hash = new SimpleHash(algorithmName, password, username + salt, hashIterations);  
		String encodedPassword = hash.toHex(); 
		userInfo.setPassword(encodedPassword);
		userInfo.setSalt(salt);
		LOGGER.info("UserInfo:{}",userInfo);
		return userInfoRepository.save(userInfo);
	}
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public UserInfo update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		LOGGER.info("UserInfoServiceImpl.update()");
		return save(userInfo);
	}

}
