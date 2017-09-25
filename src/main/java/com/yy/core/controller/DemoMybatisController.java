package com.yy.core.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.core.bean.Demo;
import com.yy.core.service.DemoMybatisService;

@RestController
public class DemoMybatisController {
    @Autowired
    private DemoMybatisService demoService;
    
//    @RequiresPermissions("Demo:likeName")//权限管理;
    /* (non-Javadoc)
	 * @see com.yy.core.controller.DemoMybatisService#findAll(java.lang.Integer, java.lang.Integer)
	 */
	@RequestMapping("/findAll")
    public String findAll(Integer pageNum, Integer pageSize){
    	 pageNum = pageNum == null ? 1 : pageNum;  
    	 pageSize = pageSize == null ? 10 : pageSize;  
    	/*  
         * 第一个参数是第几页；第二个参数是每页显示条数。  
         */  
    	PageHelper.startPage(pageNum,pageSize);
    	List<Demo> ds = demoService.findAll();
    	PageInfo<Demo> pageInfo = new PageInfo<Demo>(ds);  
        Page<Demo> page = (Page<Demo>) ds;  
       return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " + JSON.toJSONString(page);  
    }
    
    /* (non-Javadoc)
	 * @see com.yy.core.controller.DemoMybatisService#likeName(java.lang.String)
	 */
	@RequestMapping("/likeName")
    public List<Demo> likeName(String name){
    	List<Demo> ds = demoService.likeName(name);
    	ds = demoService.likeName(name);
    	return ds;  
    }
}

