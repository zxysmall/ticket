package com.yy.core.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yy.core.bean.Demo;
import com.yy.core.mapper.DemoMapper;
import com.yy.core.service.DemoMybatisService;
@Service
public class DemoMybatisServiceImpl implements DemoMybatisService {
	
	@Autowired
    private DemoMapper demoMapper;

    /* (non-Javadoc)
	 * @see com.yy.core.service.impl.DemoMybatisService#likeName(java.lang.String)
	 */
    @Override
	@Cacheable(value=DEMO_CACHE_NAME,key="'demoInfo_'+#name")
    public List<Demo> likeName(String name){
    	 System.err.println("没有走缓存！" + name);
        return demoMapper.likeName(name);
    }
    
    /* (non-Javadoc)
	 * @see com.yy.core.service.impl.DemoMybatisService#findAll()
	 */
    @Override
	public List<Demo> findAll()
    {
    	return demoMapper.findAll();
    };
}

