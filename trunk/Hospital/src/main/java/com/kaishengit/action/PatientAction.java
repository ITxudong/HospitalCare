package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Illintro;
import com.kaishengit.pojo.Insurance;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.IllintroService;
import com.kaishengit.service.InsuranceService;
import com.kaishengit.service.PatientService;
import com.kaishengit.util.PropertyFilter;

@Namespace("/patient")
public class PatientAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private PatientService patientService;
	@Inject
	private InsuranceService insuranceService;
	@Inject
	private IllintroService illintroService;
	
	private Patient patient;
	private String id;
	
	private List<Insurance> insurances;
	private List<Patient> list;
	private List<Illintro> illintros;
	
	@Action(value="patientlist",results={
			@Result(name="success",location="/WEB-INF/content/patient/patientlist.jsp")
	})
	public String patientlist() {
		List<PropertyFilter> filterList = PropertyFilter.builderPropertyFilter(getHttpRequest());
		list = patientService.search(filterList);
		
		return SUCCESS;
	}
	
	@Action(value="newPatient",results={
			@Result(name="success",location="/WEB-INF/content/patient/patient-new.jsp")
	})
	public String newPatient() {
		insurances = insuranceService.findAll();
		return SUCCESS;
	}
	
	@Action(value="savePatient",results={
			@Result(name="success",type="redirectAction",params={"namespace","/patient","actionName","patientlist"})
	})
	public String savePatient() {
		patientService.save(patient);
		return SUCCESS;
	}

	@Action(value="detail",results={
			@Result(name="success",location="/WEB-INF/content/patient/patient-detail.jsp")
	})
	public String patientDetail() {
		patient = patientService.findById(id);
		illintros = illintroService.findAllByPatientid(patient);
		return SUCCESS;
	}
	
	@Action(value="update",results={
			@Result(name="success",location="/WEB-INF/content/patient/patient-update.jsp")
	})
	public String update() {
		insurances = insuranceService.findAll();
		patient = patientService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="updatePatient",results={
			@Result(name="success",type="redirectAction",params={"namespace","/patient","actionName","patientlist"})
	})
	public String updatePatient() {
		patientService.update(patient);
		return SUCCESS;
	}
	@Action(value="del",results={
			@Result(name="success",type="redirectAction",params={"namespace","/patient","actionName","patientlist"})
	})
	public String del() {
		patientService.del(id);
		return SUCCESS;
	}
	
	
	//get set
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> getList() {
		return list;
	}

	public void setList(List<Patient> list) {
		this.list = list;
	}

	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Illintro> getIllintros() {
		return illintros;
	}

	public void setIllintros(List<Illintro> illintros) {
		this.illintros = illintros;
	}

	
}
