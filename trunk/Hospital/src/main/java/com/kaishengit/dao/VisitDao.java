package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;

import com.kaishengit.pojo.Visit;
import com.kaishengit.util.PropertyFilter;

@Named
public class VisitDao extends BaseDao<Visit,String>{

	public List<Visit> findAllByOthers(List<PropertyFilter> filterList) {
		Criteria cri = createCriteria().createAlias("Visit.patient", "patient");
		buildCondition(cri,filterList);
		return cri.list();
	}

	
}
