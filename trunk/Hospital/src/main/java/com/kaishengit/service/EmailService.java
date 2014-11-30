package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.dao.EmailDao;
import com.kaishengit.dao.ToAccountDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Email;
import com.kaishengit.pojo.ToAccount;

@Named
@Transactional
public class EmailService {

	@Inject
	private EmailDao emailDao;
	@Inject
	private ToAccountDao toAccountDao;
	@Inject
	private AccountDao accountDao;
	
	public void save(Email email, String[] persons, Account account) {
		email.setAccount(account);
		emailDao.save(email);
		
		for(String str : persons) {
			Account acc = accountDao.findById(str);
			
			ToAccount ta = new ToAccount();
			ta.setEmail(email);
			ta.setAccount(acc);
			toAccountDao.save(ta);
		}
		
		
	}

	public ToAccount findByToAccountid(String id) {
		return toAccountDao.findById(id);
	}

	public List<ToAccount> findByAccount(Account account) {
		return toAccountDao.findListByProperty("account.id", account.getId());
	}

	public Email findById(String id) {
		return emailDao.findById(id);
	}

	public List<Email> findByFromAccount(Account currAccount) {
		return emailDao.findListByProperty("account.id", currAccount.getId());
	}

	
}
