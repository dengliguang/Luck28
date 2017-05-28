package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 北京表
 * @author Administrator
 *
 */
public class Beijing implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer beijingId;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer code;
	private Date time;
	public Beijing() {
		super();
	}
	public Beijing(Integer beijingId, Integer one, Integer two, Integer three, Integer code, Date time) {
		super();
		this.beijingId = beijingId;
		this.one = one;
		this.two = two;
		this.three = three;
		this.code = code;
		this.time = time;
	}
	public Integer getBeijingId() {
		return beijingId;
	}
	public void setBeijingId(Integer beijingId) {
		this.beijingId = beijingId;
	}
	public Integer getOne() {
		return one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	public Integer getTwo() {
		return two;
	}
	public void setTwo(Integer two) {
		this.two = two;
	}
	public Integer getThree() {
		return three;
	}
	public void setThree(Integer three) {
		this.three = three;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
