package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Illintro;
import com.kaishengit.util.PropertyFilter;

@Named
public class IllintroDao extends BaseDao<Illintro ,String>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Illintro> findAll(List<PropertyFilter> filterList) {
		Criteria cri = createCriteria().createAlias("patient", "patient");
		buildCondition(cri,filterList);
		return cri.list();
	}

	public Long countDisease(List<PropertyFilter> filterList, String id) {
		Criteria cri = getSession().createCriteria(Illintro.class);
		buildCondition(cri, filterList);
		cri.add(Restrictions.eq("disease.id", id));
		cri.setProjection(Projections.count("id"));
		return (Long) cri.uniqueResult();
	}
	
}
