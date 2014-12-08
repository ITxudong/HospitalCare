package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Announce;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.AnnounceService;

@Namespace("/")
public class HomeAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AccountService accountService;
	@Inject
	private AnnounceService announceService;
	
	private List<Announce> announces;
	
	private Account account;
	
	private String id;
	
	@Action("home")
	public String execute() {
		announces = announceService.findAll();
		return SUCCESS;
	}
	
	@Action("index")
	public String index() {
		return SUCCESS;
	}
	
	@Action(value="login",results={
			@Result(name="success",type="redirectAction",params={"namespace","/","actionName","home","id","${id}"}),
			@Result(name="input",location="/WEB-INF/content/index-success.jsp")
	})
	public String login() {
		
		account = accountService.login(account,getHttpRequest());
		if(account != null) {
			HttpSession session = getHttpRequest().getSession();
			session.setAttribute("currAccount", account);
			id = account.getId();
			return SUCCESS;
		} else {
			return INPUT;
		}
	}


	//set get
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Announce> getAnnounces() {
		return announces;
	}

	public void setAnnounces(List<Announce> announces) {
		this.announces = announces;
	}

	
}
