package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Beijing;

/**
 * 北京逻辑层接口
 * @author yy
 *
 */
public interface BeijingService {
	/** 新增北京 */	
	public boolean addBeijing(Beijing beijing) ;	
	/** 删除北京 */	
	public boolean delBeijing(Integer beijingId) ;
	/** 更新北京*/	
	public boolean updateBeijing(Beijing beijing);
	/** 装载北京 */	
	public Beijing loadBeijing(Integer beijingId);
	/** 北京总共数目 */	
	public int countAll();
	/** 分页北京信息 */
	public List<Beijing> browsePagingBeijing(int pageNum,int pageSize,String orderName,String orderWay) ;
}
