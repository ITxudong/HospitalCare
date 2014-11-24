package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.VisitDao;
import com.kaishengit.pojo.Visit;
import com.kaishengit.util.PropertyFilter;

@Named
@Transactional
public class VisitService {

	@Inject
	private VisitDao visitDao;

	public List<Visit> search(List<PropertyFilter> filterList) {
		return visitDao.findAll(filterList);
	}

	public void save(Visit visit) {
		String createtime = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
		visit.setCreatetime(createtime);
	    visitDao.save(visit);
	}

	public List<Visit> findAll(String id) {
		return visitDao.findListByProperty("patient.id", id);
	}

	public Visit findById(String vid) {
		return visitDao.findById(vid);
	}
	
}
