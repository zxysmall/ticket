package com.yy.ticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.yy.core.bean.UserInfo;
import com.yy.core.util.DateUtil;
import com.yy.ticket.bean.BusiTicketOrder;
import com.yy.ticket.content.BusiContent;
import com.yy.ticket.mapper.BusiTicketOrderMapper;
import com.yy.ticket.service.BusiTicketOrderService;
import com.yy.ticket.vo.BusiTicketOrderVo;
import com.yy.ticket.vo.StatisticsVo;

@Service
public class BusiTicketOrderServiceImpl implements BusiTicketOrderService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(BusiTicketOrderServiceImpl.class);

	 
	@Autowired
	private BusiTicketOrderMapper ticketOrderMapper;
	
	@Override
	public PageInfo<BusiTicketOrderVo> findAll() {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		List<BusiTicketOrder> bt = ticketOrderMapper.findAll(ui.getUid());
		return  conventData(bt);
	}

	private PageInfo<BusiTicketOrderVo>  conventData(List<BusiTicketOrder> bt) {
//		PageInfo<BusiTicketOrder> pageInfo = new PageInfo<BusiTicketOrder>(bt); 
		PageInfo<BusiTicketOrderVo> _pageInfo = new PageInfo<BusiTicketOrderVo>();
		BeanUtils.copyProperties(bt,_pageInfo);
		List<BusiTicketOrderVo> btvs = new ArrayList<>();
		for (BusiTicketOrder busiTicketOrder : bt) {
			BusiTicketOrderVo btv = new BusiTicketOrderVo();
			BeanUtils.copyProperties(busiTicketOrder, btv);
			btv.setDate(DateUtil.getToShotFormat(BusiContent.MM_DD,busiTicketOrder.getCreateTime()));
			btv.setTime(DateUtil.getToShotFormat(BusiContent.HH_MM,busiTicketOrder.getCreateTime()));
			btvs.add(btv);
		}
		_pageInfo.setList(btvs);
		return _pageInfo;
	}

	@Override
	public BusiTicketOrderVo findById(long id) {
		// TODO Auto-generated method stub
		BusiTicketOrder bt = ticketOrderMapper.findById(id);
		BusiTicketOrderVo btv = new BusiTicketOrderVo();
		BeanUtils.copyProperties(bt, btv);
		return btv;
	}

	@Override
	public PageInfo<BusiTicketOrderVo> findByTicketId(String id) {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		List<BusiTicketOrder> bt = ticketOrderMapper.findByTicketId(id,ui.getUid());
		return conventData(bt);
	}

	@Override
	public PageInfo<BusiTicketOrderVo> findByCreateTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		List<BusiTicketOrder> bt = ticketOrderMapper.findByCreateTime(startTime, endTime,ui.getUid());
		return conventData(bt);
	}

	@Override
	public int save(BusiTicketOrderVo order) {
		// TODO Auto-generated method stub
		BusiTicketOrder o = new BusiTicketOrder();
		BeanUtils.copyProperties(order, o);
		UserInfo ui = getUserInfo();
		o.setCreateUserid(ui.getUid());
		o.setTicketPersonIdentity(order.ticketPersonIdentity);
		return ticketOrderMapper.save(o);
	}

	private UserInfo getUserInfo() {
		Subject sb =  SecurityUtils.getSubject();
		LOGGER.info("principal:{}",sb.getPrincipal());
		UserInfo ui = (UserInfo) sb.getPrincipal();
		return ui;
	}

	@Override
	public int update(BusiTicketOrder order) {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		order.setUpdateUserid(ui.getUid());
		return ticketOrderMapper.update(order);
	}

	@Override
	public PageInfo<BusiTicketOrderVo> findByStatus(int status,String ticketId) {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		List<BusiTicketOrder> bt = ticketOrderMapper.findByStatus(status,ticketId,ui.getUid());
		return conventData(bt);
	}

	@Override
	public StatisticsVo findStatisticsByCreateTime(String startTime, String endTime) {
		// TODO Auto-generated method stub
		UserInfo ui = getUserInfo();
		return ticketOrderMapper.findStatisticsByCreateTime(startTime, endTime, ui.getUid());
	}

}
