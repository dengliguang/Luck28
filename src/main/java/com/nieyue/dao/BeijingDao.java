package com.nieyue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nieyue.bean.Beijing;

/**
 * 北京数据库接口
 * @author yy
 *
 */
@Mapper
public interface BeijingDao {
	/** 新增北京*/	
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
	public List<Beijing> browsePagingBeijing(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize,@Param("orderName")String orderName,@Param("orderWay")String orderWay) ;		
}
