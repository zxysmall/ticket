package com.yy.core.service;

import java.util.List;

import com.yy.core.bean.Demo;

public interface DemoMybatisService {

	/**
	 * 这里的单引号不能少，否则会报错，被识别是一个对象;
	 */
	String CACHE_KEY = "'demoInfo'";
	/**
	 * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
	 */
	String DEMO_CACHE_NAME = "TMP_EHCACHE";

	List<Demo> likeName(String name);

	List<Demo> findAll();

}