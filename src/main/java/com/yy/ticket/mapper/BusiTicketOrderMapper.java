package com.yy.ticket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yy.ticket.bean.BusiTicketOrder;
import com.yy.ticket.vo.StatisticsVo;

@Mapper
public interface BusiTicketOrderMapper {
	/**
	 * 查询所有的订单信息
	 * @return
	 */
	public List<BusiTicketOrder> findAll(@Param("uid")Long uid);
	
	/**
	 * 根据ID查询订单信息
	 * @return
	 */
	public BusiTicketOrder findById(Long id);
	
	/**
	 * 根据TicketId查询订单信息
	 * @return
	 */
	public  List<BusiTicketOrder> findByTicketId(@Param("id")String id,
							@Param("uid")Long uid);
	
	/**
	 * 根据status,TicketId查询订单信息
	 * @return
	 */
	public  List<BusiTicketOrder> findByStatus(@Param("status") int status,
			@Param("ticketId")String ticketId,
			@Param("uid")Long uid);
	
	public  List<BusiTicketOrder> findByCreateTime(@Param("startTime") String startTime ,@Param("endTime")String endTime,
			@Param("uid")Long uid);
	
	/**
	 * @param startTime
	 * @param endTime
	 * @param userName 操作员
	 * @return
	 */
	public  StatisticsVo findStatisticsByCreateTime(@Param("startTime") String startTime ,
			@Param("endTime")String endTime,
			@Param("uid")Long uid);
	
	/**
	 * 保存订单信息
	 * @param order
	 * @return
	 */
	public int save(BusiTicketOrder order);
	
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	public int update(BusiTicketOrder order);
}
