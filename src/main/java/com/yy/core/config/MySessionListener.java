package com.yy.core.config;


import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MySessionListener implements SessionListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(MySessionListener.class);

    private final AtomicInteger sessionCount = new AtomicInteger(0);
    
    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        LOGGER.info("登录+1={}",sessionCount.get());
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
       LOGGER.info("登录退出-1={}",sessionCount.get());
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
       LOGGER.info("登录过期-1={}",sessionCount.get());
        
    }

    public int getSessionCount() {
        return sessionCount.get();
    }
}
