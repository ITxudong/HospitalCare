package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.pojo.Dept;

@Named
@Transactional
public class DeptService {

	@Inject
	private DeptDao deptDao;
	
	public void save(Dept dept) {
		deptDao.save(dept);
	}

	public List<Dept> findAllDept() {
		return deptDao.findAll();
	}

	public Dept findById(String id) {
		return deptDao.findById(id);
	}

	public void del(String id) {
		deptDao.del(id);
	}

}
