package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.DiseaseDao;
import com.kaishengit.pojo.Disease;
import com.kaishengit.util.PropertyFilter;

@Named
@Transactional
public class DiseaseService {

	@Inject
	private DiseaseDao diseaseDao;
	
	
	public List<Disease> search(List<PropertyFilter> filterList) {
		return diseaseDao.findAll(filterList);
	}

	public void save(Disease disease) {
		diseaseDao.save(disease);
	}

	public Disease findById(String id) {
		return diseaseDao.findById(id);
	}

	public void del(String id) {
		diseaseDao.del(id);
	}

	public List<Disease> findAll() {
		return diseaseDao.findAll();
	}

}
