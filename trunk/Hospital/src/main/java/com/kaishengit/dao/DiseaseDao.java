package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.kaishengit.pojo.Disease;
import com.kaishengit.util.PropertyFilter;

@Named
public class DiseaseDao extends BaseDao<Disease,String>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Disease> findAll(List<PropertyFilter> filterList) {
		Criteria cri = createCriteria();
		buildCondition(cri,filterList);
		cri.addOrder(Order.desc("dept.name"));
		return cri.list();
	} 
	
}
