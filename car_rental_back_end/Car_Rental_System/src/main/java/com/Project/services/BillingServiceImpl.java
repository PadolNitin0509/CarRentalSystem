package com.Project.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.daos.BillingDao;
import com.Project.entities.Billing;
@Transactional
@Service
public class BillingServiceImpl implements BillingSerivce{
	@Autowired
	private BillingDao billDao;
	
	@Override
	public Billing saveBilling(Billing billing) {
		
		return billDao.save(billing);
	}

	@Override
	public List<Billing> findAll() {
		return billDao.findAll();
	}

}
