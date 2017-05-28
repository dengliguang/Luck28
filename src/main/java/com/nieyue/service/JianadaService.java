package com.nieyue.service;

import java.util.List;

import com.nieyue.bean.Jianada;

/**
 * 加拿大逻辑层接口
 * @author yy
 *
 */
public interface JianadaService {
	/** 新增加拿大 */	
	public boolean addJianada(Jianada jianada) ;	
	/** 删除加拿大 */	
	public boolean delJianada(Integer jianadaId) ;
	/** 更新加拿大*/	
	public boolean updateJianada(Jianada jianada);
	/** 装载加拿大 */	
	public Jianada loadJianada(Integer jianadaId);
	/** 加拿大总共数目 */	
	public int countAll();
	/** 分页加拿大信息 */
	public List<Jianada> browsePagingJianada(int pageNum,int pageSize,String orderName,String orderWay) ;
}
