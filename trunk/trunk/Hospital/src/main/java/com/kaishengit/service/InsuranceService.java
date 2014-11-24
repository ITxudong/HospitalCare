package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.InsuranceDao;
import com.kaishengit.pojo.Insurance;

@Named
@Transactional
public class InsuranceService {

	@Inject
	private InsuranceDao insuranceDao;
	
	public void save(Insurance insurance) {
		insuranceDao.save(insurance);
	}

	public List<Insurance> findAll() {
		return insuranceDao.findAll();
	}

	public Insurance findById(String id) {
		return insuranceDao.findById(id);
	}

	public void del(String id) {
		insuranceDao.del(id);
	}

}
