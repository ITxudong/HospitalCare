package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Patient;

@Named
public class PatientDao extends BaseDao<Patient,String>{

	//根据当前查找条件按like方法查询符合的结果
	@SuppressWarnings("unchecked")
	public List<Patient> findAllLike(String propertyName ,String query) {
		Criteria cri = (Criteria) getSession().createCriteria(Patient.class);
		cri.add(Restrictions.like(propertyName, query, MatchMode.ANYWHERE));
		return cri.list();
	}

}
