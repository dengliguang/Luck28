package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.Beijing;
import com.nieyue.dao.BeijingDao;
import com.nieyue.service.BeijingService;
@Service
public class BeijingServiceImpl implements BeijingService{
	@Resource
	BeijingDao beijingDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addBeijing(Beijing beijing) {
		boolean b = beijingDao.addBeijing(beijing);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delBeijing(Integer beijingId) {
		boolean b = beijingDao.delBeijing(beijingId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateBeijing(Beijing beijing) {
		boolean b = beijingDao.updateBeijing(beijing);
		return b;
	}

	@Override
	public Beijing loadBeijing(Integer beijingId) {
		Beijing r = beijingDao.loadBeijing(beijingId);
		return r;
	}

	@Override
	public int countAll() {
		int c = beijingDao.countAll();
		return c;
	}

	@Override
	public List<Beijing> browsePagingBeijing(int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Beijing> l = beijingDao.browsePagingBeijing(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
