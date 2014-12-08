package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;

@Namespace("/account")
public class AccountAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private AccountService accountService;
	
	private Account account;
	
	private List<Account> accounts;
	
	private String keyword;
	private String id;
	
	//account settings
	@Action("accountSet")
	public String accountSet() {
		accounts = accountService.findAll();
		return SUCCESS;
	}
	
	@Action(value="newAccount",results={
			@Result(name="success",location="/WEB-INF/content/account/account-new.jsp")
	})
	public String newAccount() {
		return SUCCESS;
	}
	
	@Action(value="saveAccount",results={
			@Result(name="success",type="redirectAction",params={"namespace","/account","actionName","accountSet"})
	})
	public String saveAccount() {
		accountService.save(account);
		getHttpRequest().setAttribute("flash._message","添加账户成功");
		return SUCCESS;
	}
	
	@Action(value="updateAccount",results={
			@Result(name="success",type="redirectAction",params={"namespace","/account","actionName","accountSet"})
	})
	public String updateAccount() {
		accountService.update(account);
		getHttpRequest().setAttribute("flash._message","账户修改成功");
		return SUCCESS;
	}
	
	@Action(value="del",results={
			@Result(name="success",type="redirectAction",params={"namespace","/account","actionName","accountSet"})
	})
	public String del() {
		accountService.del(id);
		getHttpRequest().setAttribute("flash._message","添加删除成功");
		return SUCCESS;
	}
	
	@Action(value="enable",results={
			@Result(name="success",type="redirectAction",params={"namespace","/account","actionName","accountSet"})
	})
	public String enable() {
		accountService.enable(id);
		getHttpRequest().setAttribute("flash._message","添加禁用成功");
		return SUCCESS;
	}
	
	
	
	
	//perAccount settings
	@Action("perSet")
	public String perSet() {
		account = accountService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="savePerset",results={
			@Result(name="success",type="redirectAction",params={"namespace","/account","actionName","perSet","id","${account.id}"})
	})
	public String savePerset() {
		accountService.update(account);
		getHttpRequest().setAttribute("flash._message","个人信息修改成功");
		return SUCCESS;
	}

	@Action(value="update",results={
			@Result(name="success",location="/WEB-INF/content/account/account-update.jsp")
	})
	public String update() {
		account = accountService.findById(id);
		return SUCCESS;
	}
	
	//get set
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}
