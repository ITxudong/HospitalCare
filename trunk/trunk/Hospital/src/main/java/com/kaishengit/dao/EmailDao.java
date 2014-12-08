package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Email;

@Named
@SuppressWarnings("unchecked")
public class EmailDao extends BaseDao<Email,String>{

	@Override
	public List<Email> findListByProperty(String propertyName,String value) {
		Criteria cri = createCriteria().createAlias("account", "account");
		cri.add(Restrictions.eq(propertyName, value));
		return cri.list();
	}
	
	@Override
	public List<Email> findAll() {
		return createCriteria().addOrder(Order.desc("createtime")).list();
	} 
	
	
}
