package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table
public class Dept extends IdEntity{

	private String name;
	private String principal;
	@OneToMany(mappedBy="dept")
	@OrderBy("id desc")
	private List<Disease> disease;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
}
