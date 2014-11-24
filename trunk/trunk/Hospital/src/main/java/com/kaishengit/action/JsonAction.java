package com.kaishengit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.google.gson.Gson;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.PatientService;
import com.kaishengit.util.Circulate;

@Namespace("/")
public class JsonAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private PatientService patientService;
	
	private Patient patient;
	private List<Patient> patients;
	private String name;
	
	//patient 基本信息说
	@Action(value="visitJson",results={
			@Result(name="none",type="json")
	})
	public String visitJson() {
		getHttpResponse().setContentType("application/json;charset=UTF-8");
		
		name = getHttpRequest().getParameter("patientName");
		patient = patientService.findByName(name);
		
		try {
			PrintWriter out = getHttpResponse().getWriter();
			Map<String ,Object> result = new HashMap<String ,Object>();
			result.put("state", "success");
			result.put("patient", patient);
			
			out.print(new Gson().toJson(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	//返回所有patient的信息
	@Action(value="patientsJson",results={
			@Result(name="none",type="json")
	})
	public String patientsJson() {
		getHttpResponse().setContentType("application/json;charset=UTF-8");
		
		List<Patient> patients = patientService.findAll();
		
		
		try {
			PrintWriter out = getHttpResponse().getWriter();
 			Map<String ,Object> result = new HashMap<String ,Object>();
 			@SuppressWarnings("rawtypes")
			List maps = Circulate.getNames(patients);
 			result.put("query","Unit");
 			result.put("suggestions", maps);
			
			out.print(new Gson().toJson(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	
	
	
	
	
	
	//get set 
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	
	
	
}
