package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Dept extends IdEntity{

	private String name;
	private String principal;
	@OneToMany(mappedBy="dept")
	private List<Disease> diseases;
	
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

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	
	
}
