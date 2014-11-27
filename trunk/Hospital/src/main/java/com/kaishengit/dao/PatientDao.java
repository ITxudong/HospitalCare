package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Patient;

@Named
public class PatientDao extends BaseDao<Patient,String>{

	//���ݵ�ǰ����������like������ѯ���ϵĽ��
	@SuppressWarnings("unchecked")
	public List<Patient> findAllLike(String propertyName ,String query) {
		Criteria cri = (Criteria) getSession().createCriteria(Patient.class);
		cri.add(Restrictions.like(propertyName, query, MatchMode.ANYWHERE));
		return cri.list();
	}

}
