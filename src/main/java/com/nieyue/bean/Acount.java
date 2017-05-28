package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户表
 * @author Administrator
 *
 */
public class Acount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer acountId;
	private String phone;
	private String email;
	private String password;
	private Date createDate;
	private Date loginDate;
	public Acount(Integer acountId, String phone, String email, String password, Date createDate, Date loginDate) {
		super();
		this.acountId = acountId;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.loginDate = loginDate;
	}
	public Acount() {
		super();
	}
	public Integer getAcountId() {
		return acountId;
	}
	public void setAcountId(Integer acountId) {
		this.acountId = acountId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}
