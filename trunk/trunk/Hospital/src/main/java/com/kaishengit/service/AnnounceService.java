package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.AnnounceDao;
import com.kaishengit.dao.ViewcountDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Announce;
import com.kaishengit.pojo.Viewcount;

@Named
@Transactional
public class AnnounceService {

	@Inject
	private AnnounceDao announceDao;
	@Inject
	private ViewcountDao viewcountDao;
	
	public void save(Announce announce, Account account) {
		announce.setCreatetime(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		announce.setAccount(account);
		announceDao.save(announce);
	}

	public List<Announce> findAll() {
		return announceDao.findAll();
	}

	public Announce findById(String id) {
		return announceDao.findById(id);
	}

	public void saveViewcount(Account currAccount ,Announce announce) {
		if(!currAccount.getId().equals(announce.getAccount().getId())) {
			Viewcount co = viewcountDao.findEntityByAnnounceAndAccount("account.id", currAccount.getId(),"announce.id",announce.getId());
			if(co == null) {
				System.out.println("save");
				Viewcount count = new Viewcount();
				count.setAccount(currAccount);
				count.setAnnounce(announce);
				viewcountDao.save(count);
			}
		}
	}

	public List<Viewcount> findAllcounts() {
		return viewcountDao.findAll();
	}
	
	
}
