package com.kaishengit.action;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;

@Namespace("/")
public class HomeAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AccountService accountService;
	
	private Account account;
	
	@Action("home")
	public String execute() {
		return SUCCESS;
	}
	
	@Action("index")
	public String index() {
		return SUCCESS;
	}
	
	@Action(value="login",results={
			@Result(name="success",type="redirectAction",params={"namespace","/","actionName","home"}),
			@Result(name="input",location="/WEB-INF/content/index-success.jsp")
	})
	public String login() {
		
		account = accountService.login(account,getHttpRequest());
		if(account != null) {
			HttpSession session = getHttpRequest().getSession();
			session.setAttribute("currAccount", account);
			
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
}
