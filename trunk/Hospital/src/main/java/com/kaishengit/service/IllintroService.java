package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.IllintroDao;
import com.kaishengit.pojo.Illintro;
import com.kaishengit.util.PropertyFilter;

@Named
@Transactional
public class IllintroService {

	@Inject
	private IllintroDao illintroDao;
	
	public void save(Illintro illintro) {
		String createtime = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
		illintro.setCreatetime(createtime);
		illintro.setState("дкея");
		illintroDao.save(illintro);
	}

	public List<Illintro> search(List<PropertyFilter> filterList) {
		return illintroDao.findAll(filterList);
	}

	public Illintro findById(String id) {
		return illintroDao.findById(id);
	}

	public void update(Illintro illintro) {
		Illintro ill = findById(illintro.getId());
		ill.setPreresult(illintro.getPreresult());
		ill.setDept(illintro.getDept());
		ill.setDisease(illintro.getDisease());
		ill.setDoctor(illintro.getDoctor());
		ill.setAllergic(illintro.getAllergic());
		ill.setRechecktime(illintro.getRechecktime());
		illintroDao.save(ill);
	}
	
}
