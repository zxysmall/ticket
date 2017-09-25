package com.yy.ticket.vo;

public class StatisticsVo {
	private Long createUserid;// 创建人
	private String username;// 创建人
	private Integer singleNum;// 单票数
	private Integer singleNumPrivilege;// 单优票数
	private Integer doubleNum;// 双票数
	private Integer doubleNumPrivilege;// 双优票数
	public Long getCreateUserid() {
		return createUserid;
	}
	public void setCreateUserid(Long createUserid) {
		this.createUserid = createUserid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSingleNum() {
		return singleNum==null?0:singleNum;
	}
	public void setSingleNum(Integer singleNum) {
		this.singleNum = singleNum;
	}
	public Integer getSingleNumPrivilege() {
		return singleNumPrivilege==null?0:singleNumPrivilege;
	}
	public void setSingleNumPrivilege(Integer singleNumPrivilege) {
		this.singleNumPrivilege = singleNumPrivilege;
	}
	public Integer getDoubleNum() {
		return doubleNum ==null?0:doubleNum;
	}
	public void setDoubleNum(Integer doubleNum) {
		this.doubleNum = doubleNum;
	}
	public Integer getDoubleNumPrivilege() {
		return doubleNumPrivilege ==null?0:doubleNumPrivilege;
	}
	public void setDoubleNumPrivilege(Integer doubleNumPrivilege) {
		this.doubleNumPrivilege = doubleNumPrivilege;
	}
	
}
