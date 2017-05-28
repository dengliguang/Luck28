package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Acount;

/**
 * 账户逻辑层接口
 * @author yy
 *
 */
public interface AcountService {
	/** 新增账户 */	
	public boolean addAcount(Acount acount) ;	
	/** 删除账户 */	
	public boolean delAcount(Integer acountId) ;
	/** 更新账户*/	
	public boolean updateAcount(Acount acount);
	/** 装载账户 */	
	public Acount loadAcount(Integer acountId);
	/** 登录管理员 */	
	public Acount loginAcount(String adminName,String password);
	/** 账户总共数目 */	
	public int countAll();
	/** 分页账户信息 */
	public List<Acount> browsePagingAcount(int pageNum,int pageSize,String orderName,String orderWay) ;
}
