package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.PatientDao;
import com.kaishengit.pojo.Patient;
import com.kaishengit.util.PropertyFilter;

@Named
@Transactional
public class PatientService {

	@Inject
	private PatientDao patientDao;
	
	public List<Patient> findAll() {
		return patientDao.findAll();
	}

	public void save(Patient patient) {
		String createtime = DateTime.now().toString("yyyy-MM-dd");
		patient.setCreatetime(createtime);
		patient.setState("дкея");
		patientDao.save(patient);
	}

	public void update(Patient patient) {
		Patient p = findById(patient.getId());
		p.setName(patient.getName());
		p.setSex(patient.getSex());
		p.setPeopleid(patient.getPeopleid());
		p.setAge(patient.getAge());
		p.setTel(patient.getTel());
		p.setInsurance(patient.getInsurance());
		p.setAddress(patient.getAddress());
		p.setAllergic(patient.getAllergic());
		p.setNote(patient.getNote());
		patientDao.save(p);
	}
	
	public Patient findById(String id) {
		return patientDao.findById(id);
	}

	public void del(String id) {
		patientDao.del(id);
	}

	public List<Patient> search(List<PropertyFilter> filterList) {
		return patientDao.findAll(filterList);
	}

	public Patient findByName(String name) {
		return patientDao.findEntityByProperty("name", name);
	}

	public List<Patient> findAllLike(String query) {
		return patientDao.findAllLike("name", query);
	}



}
