package com.nieyue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nieyue.bean.Jianada;
import com.nieyue.dao.JianadaDao;
import com.nieyue.service.JianadaService;
@Service
public class JianadaServiceImpl implements JianadaService{
	@Resource
	JianadaDao jianadaDao;
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addJianada(Jianada jianada) {
		boolean b = jianadaDao.addJianada(jianada);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean delJianada(Integer jianadaId) {
		boolean b = jianadaDao.delJianada(jianadaId);
		return b;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateJianada(Jianada jianada) {
		boolean b = jianadaDao.updateJianada(jianada);
		return b;
	}

	@Override
	public Jianada loadJianada(Integer jianadaId) {
		Jianada r = jianadaDao.loadJianada(jianadaId);
		return r;
	}

	@Override
	public int countAll() {
		int c = jianadaDao.countAll();
		return c;
	}

	@Override
	public List<Jianada> browsePagingJianada(int pageNum, int pageSize,
			String orderName, String orderWay) {
		if(pageNum<1){
			pageNum=1;
		}
		if(pageSize<1){
			pageSize=0;//没有数据
		}
		List<Jianada> l = jianadaDao.browsePagingJianada(pageNum-1, pageSize, orderName, orderWay);
		return l;
	}

	
}
