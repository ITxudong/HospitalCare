package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Insurance;
import com.kaishengit.service.InsuranceService;

@Namespace("/insurance")
public class InsuranceAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private InsuranceService insuranceService;
	
	private Insurance insurance;
	
	private List<Insurance> insurances;
	
	private String id; 
	
	
	//insurance settings
	@Action("insuranceSet")
	public String insuranceSet() {
		insurances = insuranceService.findAll();
		return SUCCESS;
	}
	
	@Action(value="newInsurance",results={
			@Result(name="success",location="/WEB-INF/content/insurance/insurance-new.jsp")
	})
	public String newInsurance() {
		return SUCCESS;
	}
	
	@Action(value="saveInsurance",results={
			@Result(name="success",type="redirectAction",params={"namespace","/insurance","actionName","insuranceSet"})
	})
	public String saveInsurance() {
		insuranceService.save(insurance);
		return SUCCESS;
	}
	
	@Action(value="update",results={
			@Result(name="success",location="/WEB-INF/content/insurance/insurance-update.jsp")
	})
	public String update() {
		insurance = insuranceService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="updateInsurance",results={
			@Result(name="success",type="redirectAction",params={"namespace","/insurance","actionName","insuranceSet"})
	})
	public String updateInsurance() {
		insuranceService.save(insurance);
		return SUCCESS;
	}
	
	@Action(value="del",results={
			@Result(name="success",type="redirectAction",params={"namespace","/insurance","actionName","insuranceSet"})
	})
	public String del() {
		insuranceService.del(id);
		return SUCCESS;
	}
	
	//get set
	
	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
}
