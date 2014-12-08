package com.kaishengit.dao;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Viewcount;

@Named
public class ViewcountDao extends BaseDao<Viewcount,String>{

	public Viewcount findEntityByAnnounceAndAccount(String propertyName, String accountid, String propertyName2, String announceid) {
		Criteria cri = createCriteria();
		cri.add(Restrictions.eq(propertyName, accountid));
		cri.add(Restrictions.eq(propertyName2, announceid));
		return (Viewcount) cri.uniqueResult();
	}

	
	
	
}
