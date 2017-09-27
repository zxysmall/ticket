package com.yy.core;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类.
 * @version v.0.1
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.yy"}) 
@MapperScan("com.yy.**.mapper")
//@EnableCaching(proxyTargetClass = true) // 开启缓存功能
public class YyApplication  extends SpringBootServletInitializer implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(YyApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(YyApplication.class);
    }
    
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(YyApplication.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();  
	    for (String profile : activeProfiles) {  
	    	LOGGER.info("Spring Boot 使用profile为:{}" , profile);  
	    }  
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("springboot启动完成！");
	}
	
}
