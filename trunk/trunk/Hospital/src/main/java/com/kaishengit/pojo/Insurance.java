package com.kaishengit.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Insurance extends IdEntity{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
