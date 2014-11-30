package com.kaishengit.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.kaishengit.pojo.Email;
import com.kaishengit.pojo.ToAccount;

@Named
public class ToAccountDao extends BaseDao<ToAccount,String >{

	@Override
	public List<ToAccount> findListByProperty(String propertyName,String value) {
		Criteria cri = createCriteria().createAlias("account", "account");
		cri.add(Restrictions.eq(propertyName, value));
		return cri.list();
	}

}
