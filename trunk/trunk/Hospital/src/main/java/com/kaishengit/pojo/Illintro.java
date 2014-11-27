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
public class Illintro extends IdEntity{

	private String preresult;
	private String doctor;
	private String createtime;
	private String rechecktime;
	private String state;
	private String allergic;
	@ManyToOne
	@JoinColumn(name="deptid")
	private Dept dept;
	@ManyToOne
	@JoinColumn(name="diseaseid")
	private Disease disease;
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patient;
	@OneToMany(mappedBy="illintro")
	private List<Visit> visits;
	
	public String getPreresult() {
		return preresult;
	}
	public void setPreresult(String preresult) {
		this.preresult = preresult;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getRechecktime() {
		return rechecktime;
	}
	public void setRechecktime(String rechecktime) {
		this.rechecktime = rechecktime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getAllergic() {
		return allergic;
	}
	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	
	
	
	
}
