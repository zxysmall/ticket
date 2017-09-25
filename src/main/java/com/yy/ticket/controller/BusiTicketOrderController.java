package com.yy.ticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.core.bean.UserInfo;
import com.yy.core.util.StringUtil;
import com.yy.ticket.bean.BusiTicketOrder;
import com.yy.ticket.service.BusiTicketOrderService;
import com.yy.ticket.vo.BusiTicketOrderVo;
import com.yy.ticket.vo.StatisticsVo;

@RestController
@RequestMapping("/order")
public class BusiTicketOrderController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(BusiTicketOrderController.class);

	 
	@Autowired
	private BusiTicketOrderService busiTicketOrderService;
	
	@Autowired
	protected HttpServletRequest request;
	  
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	@RequestMapping("/findAll")
	public String findAll(){
		 Integer pageNum =request.getParameter("pageNum")==null?null:Integer.valueOf(request.getParameter("pageNum"));
		 Integer pageSize = request.getParameter("pageSize")==null?null:Integer.valueOf(request.getParameter("pageSize"));
		 String searchId = request.getParameter("searchId");
		 String status = request.getParameter("status");
		 pageNum = pageNum == null ? 1 : pageNum;  
    	 pageSize = pageSize == null ? 10 : pageSize;  
    	/*  
         * 第一个参数是第几页；第二个参数是每页显示条数。  
         */  
    	PageHelper.startPage(pageNum,pageSize);
    	PageInfo<BusiTicketOrderVo> pageInfo = null;
    	if(StringUtil.isBlank(searchId)&&StringUtil.isBlank(status))
    	 pageInfo = busiTicketOrderService.findAll();
    	else if(!StringUtil.isBlank(status)){
    		pageInfo = busiTicketOrderService.findByStatus(Integer.valueOf(status),searchId);
    	}
    	else{
    		pageInfo = busiTicketOrderService.findByTicketId(searchId);
    	}
        LOGGER.info("PageInfo:{}",JSON.toJSONString(pageInfo));
//        Page<BusiTicketOrderVo> page = (Page<BusiTicketOrderVo>) ds;  
//        LOGGER.info("page:{}",JSON.toJSONString(page));
       return JSON.toJSONString(pageInfo);  
	};
	
	@RequestMapping("/findById")
	public String findById(long id){
		BusiTicketOrderVo btv = busiTicketOrderService.findById(id);
		 return JSON.toJSONString(btv);
	};
	
	@RequestMapping("/update")
	public String update(Long id,String ticketNum)
	{
		LOGGER.info("id:{},ticketNum:{}",id,ticketNum);
		
		if(id == null || StringUtil.isBlank(ticketNum))
			return "参数错误";
		BusiTicketOrder order = new BusiTicketOrder();
		order.setId(id);
		order.setTicketNum(ticketNum);
		return busiTicketOrderService.update(order) +"";
	};
	
	@RequestMapping("/findStatistics")
	public String findStatistics()
	{
		 String startTime = request.getParameter("startTime");
		 String endTime = request.getParameter("endTime");
		 if(!StringUtil.isBlank(endTime))
			 endTime+=" 23:59:59";
		 StatisticsVo sv = busiTicketOrderService.findStatisticsByCreateTime(startTime, endTime);
		 if(sv == null)
		 {
			 Subject sb =  SecurityUtils.getSubject();
			 LOGGER.info("principal:{}",sb.getPrincipal());
			 UserInfo ui = (UserInfo) sb.getPrincipal();
			 String username = ui.getUsername();
			 sv = new StatisticsVo();
			 sv.setUsername(username);
			 sv.setCreateUserid(ui.getUid());
		 }
		 return JSON.toJSONString(sv);
	}
	
	/**
	 * 保存订单信息
	 * @param order
	 * @return
	 */
	@RequestMapping("/save")
	public String save(BusiTicketOrderVo order){
		String result = "";
		if(!order.validate())result = "提交参数有误";
		else
		{
			int i = busiTicketOrderService.save(order);
			result = i + "";
		}
		return result;
	};
}
