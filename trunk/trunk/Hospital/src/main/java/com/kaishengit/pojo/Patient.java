package com.kaishengit.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Patient extends IdEntity{

	private String name;
	private String sex;
	private String peopleid;
	private Integer age;
	private String tel;
	private String address;
	private String allergic;
	private String note;
	private String createtime;
	private String state;
	@ManyToOne
	@JoinColumn(name="insuranceid")
	private Insurance insurance;
	//@OneToMany(mappedBy="patient")
	//private List<Illintro> illintros;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPeopleid() {
		return peopleid;
	}
	public void setPeopleid(String peopleid) {
		this.peopleid = peopleid;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAllergic() {
		return allergic;
	}
	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	/*public List<Illintro> getIllintros() {
		return illintros;
	}
	public void setIllintros(List<Illintro> illintros) {
		this.illintros = illintros;
	}*/
	
}
