package com.yy.ticket;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yy.core.BaseTest;
import com.yy.ticket.bean.BusiTicketOrder;
import com.yy.ticket.service.BusiTicketOrderService;
import com.yy.ticket.vo.BusiTicketOrderVo;
import com.yy.ticket.vo.StatisticsVo;

public class BusiTicketOrderServiceTest extends BaseTest {
	@Autowired
	private BusiTicketOrderService ticketOrderService;
	
    @Test
    public void findAll() {
    	PageHelper.startPage(1,10);
    	PageInfo<BusiTicketOrderVo> pageInfo =  ticketOrderService.findAll();
        LOGGER.info("PageInfo:{}",JSON.toJSONString(pageInfo));
    }
    @Test
    public void findById() {
    	BusiTicketOrderVo bto =  ticketOrderService.findById(1L);
    	LOGGER.info("BusiTicketOrder:{}",JSON.toJSONString(bto));
    }
    @Test
    public void findByTicketId() {
    	PageInfo<BusiTicketOrderVo> bto =  ticketOrderService.findByTicketId("1111");
    	LOGGER.info("BusiTicketOrder:{}",JSON.toJSONString(bto));
    }
    
    @Test
    public void findStatisticsByCreateTime() {
    	StatisticsVo bto =  ticketOrderService.findStatisticsByCreateTime("", "");
    	LOGGER.info("BusiTicketOrder:{}",JSON.toJSONString(bto));
    }
    @Test
    public void findByCreateTime() {
    	PageInfo<BusiTicketOrderVo> bto =  ticketOrderService.findByCreateTime("2017-08-10 16:47:20", "2017-08-11 16:47:20");
    	LOGGER.info("BusiTicketOrder:{}",JSON.toJSONString(bto));
    }
    @Test
    public void save() {
    	for (int i = 0; i < 1000; i++) {
    		Long num = Long.valueOf(new Random().nextInt(5));
    		BusiTicketOrderVo order = new BusiTicketOrderVo();
    		order.setSingleNum(num);
    		order.setSingleNumPrivilege(num%2);
    		if(i%5 == 0)
    		{
    			order.setDoubleNum(num);
        		order.setDoubleNumPrivilege(num%2);
    		}
    		order.setStatus(new Random().nextInt(2));
    		order.setTicketPerson("王"+i);
    		order.setTicketPersonIdentity(String.format("%016d", i));
    		order.setTicketPersonPhone("123333"+i);
//    		order.setCreateUserid(1L);
    		int j =  ticketOrderService.save(order);
    		LOGGER.info("BusiTicketOrder:{}",j);
		}
    }
    @Test
    public void update() {
    	BusiTicketOrder order = new BusiTicketOrder();
    	order.setId(5L);
    	order.setUpdateUserid(1L);
    	order.setTicketNum("1123123");
    	int i =  ticketOrderService.update(order);
    	LOGGER.info("BusiTicketOrder:{}",i);
    }
    
    public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(new Random().nextInt(2));
		}
	}
}
