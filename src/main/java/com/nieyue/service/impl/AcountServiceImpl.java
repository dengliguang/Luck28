package com.nieyue.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.Acount;
import com.nieyue.dao.AcountDao;
import com.nieyue.service.AcountService;
@Service
public class AcountServiceImpl implements AcountService{
	@Resource
	AcountDao acountDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addAcount(Acount acount) {
		Date date=new Date();
		acount.setCreateDate(date);
		acount.setLoginDate(date);
		boolean b = acountDao.addAcount(acount);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delAcount(Integer acountId) {
		boolean b = acountDao.delAcount(acountId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateAcount(Acount acount) {
		boolean b = acountDao.updateAcount(acount);
		return b;
	}

	@Override
	public Acount loadAcount(Integer acountId) {
		Acount r = acountDao.loadAcount(acountId);
		return r;
	}

	@Override
	public int countAll() {
		int c = acountDao.countAll();
		return c;
	}

	@Override
	public List<Acount> browsePagingAcount(int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Acount> l = acountDao.browsePagingAcount(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}
	@Override
	public Acount loginAcount(String adminName, String password) {
		Acount acount = acountDao.loginAcount(adminName, password);
		return acount;
	}

	
}
