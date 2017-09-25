package com.yy.ticket.service;

import com.github.pagehelper.PageInfo;
import com.yy.ticket.bean.BusiTicketOrder;
import com.yy.ticket.vo.BusiTicketOrderVo;
import com.yy.ticket.vo.StatisticsVo;

public interface BusiTicketOrderService {
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	public PageInfo<BusiTicketOrderVo> findAll();
	
	/**
	 * 根据ID查询订单信息
	 * @return
	 */
	public BusiTicketOrderVo findById(long id);
	
	/**
	 * 根据TicketId查询订单信息
	 * @return
	 */
	public  PageInfo<BusiTicketOrderVo> findByTicketId(String id);
	
	/**
	 * 根据TicketId查询订单信息
	 * @return
	 */
	public  PageInfo<BusiTicketOrderVo> findByStatus(int status,String ticketId);
	
	/**
	 * 根据TicketId查询订单信息
	 * @return
	 */
	public  PageInfo<BusiTicketOrderVo> findByCreateTime(String startTime ,String endTime);
	
	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public  StatisticsVo findStatisticsByCreateTime(String startTime ,String endTime);
	
	/**
	 * 保存订单信息
	 * @param order
	 * @return
	 */
	public int save(BusiTicketOrderVo order);
	
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public int update(BusiTicketOrder order);
}
