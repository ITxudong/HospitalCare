package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

@Entity
@Table
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Visit extends IdEntity{

	private String preresult;
	private String symptom;
	private String allergic;
	private String yxcharacter;
	private String finalresult;
	private String curemethod;
	private String doctor;
	private String createtime;
	private String rechecktime;
	private String state;
	@ManyToOne
	@JoinColumn(name="diseaseid")
	private Disease disease;
	@ManyToOne
	@JoinColumn(name="deptid")
	private Dept dept;
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patient;
	@OneToMany(mappedBy="visit")
	@OrderBy("id desc")
	private List<Imgs> imgs;
	
	
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getPreresult() {
		return preresult;
	}
	public void setPreresult(String preresult) {
		this.preresult = preresult;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getAllergic() {
		return allergic;
	}
	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
	public String getYxcharacter() {
		return yxcharacter;
	}
	public void setYxcharacter(String yxcharacter) {
		this.yxcharacter = yxcharacter;
	}
	public String getFinalresult() {
		return finalresult;
	}
	public void setFinalresult(String finalresult) {
		this.finalresult = finalresult;
	}
	public String getCuremethod() {
		return curemethod;
	}
	public void setCuremethod(String curemethod) {
		this.curemethod = curemethod;
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
	
	public String getNiceCreatetime() {
		DateTime dt = new DateTime(getCreatetime());
		return dt.toString("yyyy-MM-dd");
	}
	
	
}
