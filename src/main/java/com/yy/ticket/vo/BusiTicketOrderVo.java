package com.yy.ticket.vo;

import com.yy.core.util.StringUtil;

public class BusiTicketOrderVo {
	private Long id ;//主键
	private String date;//MM/dd
	private String time;//hh:mm
	private String ticketPerson;
	public String ticketPersonIdentity;//后四位
	private Long singleNum;// 单票数
	private Long singleNumPrivilege;// 单优票数
	private Long doubleNum;// 双票数
	private Long doubleNumPrivilege;// 双优票数
	private String ticketPersonPhone;//取票人电话
	private int status = 1;//状态（0：已出；1：未出）
	private String ticketNumlabel;//票数
	private String msg;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTicketPerson() {
		return ticketPerson;
	}
	public void setTicketPerson(String ticketPerson) {
		this.ticketPerson = ticketPerson;
	}
	public String getTicketPersonIdentity() {
		if(!StringUtil.isBlank(ticketPersonIdentity))
		return ticketPersonIdentity.substring(ticketPersonIdentity.length()-4);
		return null;
	}
	public void setTicketPersonIdentity(String ticketPersonIdentity) {
		this.ticketPersonIdentity = ticketPersonIdentity;
	}
	public String getTicketNumlabel() {
		StringBuilder sb = new StringBuilder();
		if(singleNum != 0)
			sb.append(singleNum).append("单");
		if(singleNumPrivilege != 0)
			sb.append(singleNumPrivilege).append("单优");
		if(doubleNum != 0)
			sb.append(doubleNum).append("双");
		if(doubleNumPrivilege != 0)
			sb.append(doubleNumPrivilege).append("双优");
		ticketNumlabel = sb.toString();
		return ticketNumlabel;
	}
	public void setTicketNumlabel(String ticketNumlabel) {
		this.ticketNumlabel = ticketNumlabel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSingleNum() {
		return singleNum;
	}
	public void setSingleNum(Long singleNum) {
		this.singleNum = singleNum == null ? 0:singleNum;
	}
	public Long getSingleNumPrivilege() {
		return singleNumPrivilege;
	}
	public void setSingleNumPrivilege(Long singleNumPrivilege) {
		this.singleNumPrivilege = singleNumPrivilege == null ? 0:singleNumPrivilege;
	}
	public Long getDoubleNum() {
		return doubleNum;
	}
	public void setDoubleNum(Long doubleNum) {
		this.doubleNum = doubleNum == null ? 0:doubleNum;
	}
	public Long getDoubleNumPrivilege() {
		return doubleNumPrivilege;
	}
	public void setDoubleNumPrivilege(Long doubleNumPrivilege) {
		this.doubleNumPrivilege = doubleNumPrivilege == null ? 0:doubleNumPrivilege;
	}
	public String getTicketPersonPhone() {
		return ticketPersonPhone;
	}
	public void setTicketPersonPhone(String ticketPersonPhone) {
		this.ticketPersonPhone = ticketPersonPhone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean validate(){
		if(((this.singleNum == null || this.singleNum == 0L)&&
			(this.doubleNum == null || this.doubleNum == 0L))
				||
		(StringUtil.isBlank(this.ticketPerson)||
		StringUtil.isBlank(this.ticketPersonIdentity)||
		StringUtil.isBlank(this.ticketPersonPhone))) return false;
		return true;
	}
}
