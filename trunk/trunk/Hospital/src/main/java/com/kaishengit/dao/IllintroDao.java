package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;

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
	
}
