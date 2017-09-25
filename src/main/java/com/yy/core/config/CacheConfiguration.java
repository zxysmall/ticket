package com.yy.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 缓存配置.
 * @version v.0.1
 */
@Configuration
@EnableCaching //标注启动缓存.
public class CacheConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfiguration.class);
	
	/**
	 *  ehcache 主要的管理器
	 * @param bean
	 * @return
	 */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
		LOGGER.info("CacheConfiguration.ehCacheCacheManager()"); 
		return new EhCacheCacheManager(bean.getObject());
	}
	
	/*
	   * 据shared与否的设置,
	   * Spring分别通过CacheManager.create()
	   * 或new CacheManager()方式来创建一个ehcache基地.
	   * 
	   * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
	   * 
	   */
	  @Bean
	  public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
		 LOGGER.info("CacheConfiguration.ehCacheManagerFactoryBean()");
		 EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean ();
	     cacheManagerFactoryBean.setConfigLocation (new ClassPathResource("config/ehcache.xml"));
	     cacheManagerFactoryBean.setShared(true);
	     return cacheManagerFactoryBean;
	  }
	
}

