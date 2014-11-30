package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Email;
import com.kaishengit.pojo.ToAccount;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.EmailService;

@Namespace("/email")
public class EmailAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private EmailService emailService;
	@Inject
	private AccountService accountService;
	
	
	private List<Account> accounts;
	private List<Email> emails;
	private List<ToAccount> toAccounts;
	
	private Email email;
	private ToAccount toAccount;
	private String id;
	
	@Action(value="newEmail",results={
			@Result(name="success",location="/WEB-INF/content/email/email-new.jsp")
	})
	public String newEmail() {
		accounts = accountService.findAll();
		return SUCCESS;
	}
	
	@Action(value="saveEmail",results={
			@Result(name="success",type="redirectAction",params={"namespace","/email","actionName","newEmail"})
	})
	public String saveEmail() {
		String[] persons = getHttpRequest().getParameterValues("persons");
		Account account = (Account) getHttpRequest().getSession().getAttribute("currAccount");
		emailService.save(email,persons,account);
		
		return SUCCESS;
	}
	
	@Action(value="recieveEmail",results={
			@Result(name="success",location="/WEB-INF/content/email/email-recieves.jsp")
	})
	public String recieveEmail() {
		Account account = accountService.findById(id);
		toAccounts = emailService.findByAccount(account);
		return SUCCESS;
	}
	
	@Action(value="detail",results={
			@Result(name="success",location="/WEB-INF/content/email/email-detail.jsp")
	})
	public String detail() {
		email = emailService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="sendEmail",results={
			@Result(name="success",location="/WEB-INF/content/email/email-sends.jsp")
	})
	public String sendEmail() {
		emails = emailService.findByFromAccount(getCurrAccount());
		return SUCCESS;
	}
	
	
	//get set
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public ToAccount getToAccount() {
		return toAccount;
	}

	public void setToAccount(ToAccount toAccount) {
		this.toAccount = toAccount;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<ToAccount> getToAccounts() {
		return toAccounts;
	}

	public void setToAccounts(List<ToAccount> toAccounts) {
		this.toAccounts = toAccounts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
