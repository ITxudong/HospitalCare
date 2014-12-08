package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Email extends IdEntity{

	private String title;
	private String content;
	@ManyToOne
	@JoinColumn(name="fromid")
	private Account account;
	@OneToMany(mappedBy="email")
	private List<ToAccount> toAccounts;
	private String createtime;
	
	
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<ToAccount> getToAccounts() {
		return toAccounts;
	}
	public void setToAccounts(List<ToAccount> toAccounts) {
		this.toAccounts = toAccounts;
	}
	
	
	
}
