package com.yy.ticket.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BusiTicketOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4101357093695235797L;
	
	@Id @GeneratedValue
	private Long id ;//主键
	private Long singleNum;// 单票数
	private Long singleNumPrivilege;// 单优票数
	private Long doubleNum;// 双票数
	private Long doubleNumPrivilege;// 双优票数
	private int status;//状态（0：已出；1：未出）
	private String ticketNum;//出票号
	private String ticketPerson;//取票人姓名
	private String ticketPersonIdentity;//取票人身份证
	private String ticketPersonPhone;//取票人电话
	private Long createUserid;// 创建人
	private Date createTime;// 创建时间
	private Long updateUserid;// 更新人
	private Date updateTime;// 更新时间
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
		this.singleNum = singleNum;
	}
	public Long getSingleNumPrivilege() {
		return singleNumPrivilege;
	}
	public void setSingleNumPrivilege(Long singleNumPrivilege) {
		this.singleNumPrivilege = singleNumPrivilege;
	}
	public Long getDoubleNum() {
		return doubleNum;
	}
	public void setDoubleNum(Long doubleNum) {
		this.doubleNum = doubleNum;
	}
	public Long getDoubleNumPrivilege() {
		return doubleNumPrivilege;
	}
	public void setDoubleNumPrivilege(Long doubleNumPrivilege) {
		this.doubleNumPrivilege = doubleNumPrivilege;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getTicketPerson() {
		return ticketPerson;
	}
	public void setTicketPerson(String ticketPerson) {
		this.ticketPerson = ticketPerson;
	}
	public String getTicketPersonIdentity() {
		return ticketPersonIdentity;
	}
	public void setTicketPersonIdentity(String ticketPersonIdentity) {
		this.ticketPersonIdentity = ticketPersonIdentity;
	}
	public String getTicketPersonPhone() {
		return ticketPersonPhone;
	}
	public void setTicketPersonPhone(String ticketPersonPhone) {
		this.ticketPersonPhone = ticketPersonPhone;
	}
	public Long getCreateUserid() {
		return createUserid;
	}
	public void setCreateUserid(Long createUserid) {
		this.createUserid = createUserid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateUserid() {
		return updateUserid;
	}
	public void setUpdateUserid(Long updateUserid) {
		this.updateUserid = updateUserid;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
