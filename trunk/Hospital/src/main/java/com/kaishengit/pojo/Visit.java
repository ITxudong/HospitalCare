package com.kaishengit.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Visit extends IdEntity{

	private String symptom;
	private String yxcharacter;
	private String finalresult;
	private String curemethod;
	private String createtime;
	@ManyToOne
	@JoinColumn(name="illintroid")
	private Illintro illintro;
	@OneToMany(mappedBy="visit")
	private List<Imgs> imgs;
	
	
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Illintro getIllintro() {
		return illintro;
	}
	public void setIllintro(Illintro illintro) {
		this.illintro = illintro;
	}
	public List<Imgs> getImgs() {
		return imgs;
	}
	public void setImgs(List<Imgs> imgs) {
		this.imgs = imgs;
	}
	
	
}
