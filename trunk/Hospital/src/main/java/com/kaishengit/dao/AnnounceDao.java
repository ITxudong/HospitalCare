package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.criterion.Order;

import com.kaishengit.pojo.Announce;

@Named
@SuppressWarnings("unchecked")
public class AnnounceDao extends BaseDao<Announce ,String>{

	@Override
	public List<Announce> findAll() {
		return createCriteria().addOrder(Order.desc("createtime")).list();
	} 
	
}
