package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Jianada;

/**
 * 北京数据库接口
 * @author yy
 *
 */
@Mapper
public interface JianadaDao {
	/** 新增北京*/	
	public boolean addJianada(Jianada jianada) ;	
	/** 删除北京 */	
	public boolean delJianada(Integer jianadaId) ;
	/** 更新北京*/	
	public boolean updateJianada(Jianada jianada);
	/** 装载北京 */	
	public Jianada loadJianada(Integer jianadaId);	
	/** 北京总共数目 */	
	public int countAll();	
	/** 分页北京信息 */
	public List<Jianada> browsePagingJianada(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
}
