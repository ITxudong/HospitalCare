package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.kaishengit.pojo.IdEntity;
import com.kaishengit.pojo.Viewcount;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Announce extends IdEntity{

	private String title;
	private String content;
	private String createtime;
	@OneToMany(mappedBy="announce")
	private List<Viewcount> counts;
	@ManyToOne
	@JoinColumn(name="pubid")
	private Account account;
	
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public List<Viewcount> getCounts() {
		return counts;
	}
	public void setCounts(List<Viewcount> counts) {
		this.counts = counts;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
