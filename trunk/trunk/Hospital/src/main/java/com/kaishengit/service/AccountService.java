package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.pojo.Account;

@Named
@Transactional
public class AccountService {

	@Inject
	private AccountDao accountDao;
	

	public Account login(Account account,HttpServletRequest request) {
		Account acc = accountDao.findEntityByProperty("accountName", account.getAccountName());
		if(acc!= null && acc.getPwd().equals(account.getPwd())) {
			//设置最后登录时间和最后登录IP
			String lastIp = request.getRemoteAddr();
			String time = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
			acc.setLastTime(time);
			acc.setLastIp(lastIp);
			return acc;
		} else {
			return null;
		}
	}


	public List<Account> findAll() {
		return accountDao.findAll();
	}


	public void update(Account account) {
		Account acc = findById(account.getId());
		acc.setRealName(account.getRealName());
		acc.setAccountName(account.getAccountName());
		acc.setPwd(account.getPwd());
		acc.setTel(account.getTel());
		acc.setType(account.getType());
		acc.setEnable(account.getEnable());
		accountDao.save(acc);
	}


	public void save(Account account) {
		account.setEnable(true);
		accountDao.save(account);
	}


	public Account findById(String id) {
		return accountDao.findById(id);
	}


	public void del(String id) {
		accountDao.del(id);
	}


	public void enable(String id) {
		Account account = findById(id);
		if(account.getEnable()) {
			account.setEnable(false);
		} else {
			account.setEnable(true);
		}
	}

}
