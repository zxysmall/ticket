package com.yy.ticket.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class UserInfoDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676036481151816818L;
	
	@Id @GeneratedValue
	private Long id ;//主键
	private Long userId;// 用户ID
//	private String nickname;// 昵称
	private String gender;//  性别（male:男，woman:女）
	private String email;// 电子邮箱
	private String contactNumber;// 联系电话
	private Long mobilePhone;// 手机
	private Long qq;// QQ号
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Long getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(Long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Long getQq() {
		return qq;
	}
	public void setQq(Long qq) {
		this.qq = qq;
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
