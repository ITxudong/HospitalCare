package com.kaishengit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.ToAccount;

@Named
public class ToAccountDao extends BaseDao<ToAccount,String >{

	@SuppressWarnings("unchecked")
	@Override
	public List<ToAccount> findListByProperty(String propertyName,String value) {
		Criteria cri = createCriteria().createAlias("account", "account");
		cri.add(Restrictions.eq(propertyName, value));
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	public List<ToAccount> findListByPropertyAndState(String propertyName, String value,
			String string, boolean b){
		Criteria cri = createCriteria().createAlias("account", "account");
		cri.add(Restrictions.eq(propertyName, value));
		cri.add(Restrictions.eq(string, b));
		List<ToAccount> list = cri.list();
		
		List li = new ArrayList();
		li.add("");
		
		if(list != null) {
			return list;
		} else {
			return li;
		}
		
	}

}
