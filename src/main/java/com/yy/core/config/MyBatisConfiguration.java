package com.yy.core.config;



import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

 
/**
 * 注册MyBatis分页插件PageHelper
 * @version v.0.1
 */

@Configuration
public class MyBatisConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisConfiguration.class);
	 
    @Bean
    public PageHelper pageHelper() {
    	LOGGER.info("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
    
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.spring.boot.web.mybatis.mapper");
//        return mapperScannerConfigurer;
//    }
    

}

