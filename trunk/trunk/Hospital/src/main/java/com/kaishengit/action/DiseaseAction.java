package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.util.PropertyFilter;

@Namespace("/disease")
public class DiseaseAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private DeptService deptService;
	@Inject
	private DiseaseService diseaseService;
	
	private Disease disease;
	
	private List<Dept> list;
	private List<Disease> diseases;
	
	private String keyword;
	private String id;
	
	
	//disease settings
	@Action("diseaseSet")
	public String deseaseSet() {
		list = deptService.findAllDept();
		List<PropertyFilter> filterList = PropertyFilter.builderPropertyFilter(getHttpRequest());
		diseases = diseaseService.search(filterList);
		return SUCCESS;
	}
	
	@Action(value="newDisease",results={
			@Result(name="success",location="/WEB-INF/content/disease/disease-new.jsp")
	})
	public String newDisease() {
		list = deptService.findAllDept();
		return SUCCESS;
	}
	
	@Action(value="saveDisease",results={
			@Result(name="success",type="redirectAction",params={"namespace","/disease","actionName","diseaseSet"})
	})
	public String saveDisease() {
		diseaseService.save(disease);
		return SUCCESS;
	}
	
	@Action(value="update",results={
			@Result(name="success",location="/WEB-INF/content/disease/disease-update.jsp")
	})
	public String update() {
		list = deptService.findAllDept();
		disease = diseaseService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="updateDisease",results={
			@Result(name="success",type="redirectAction",params={"namespace","/disease","actionName","diseaseSet"})
	})
	public String updateDept() {
		diseaseService.save(disease);
		return SUCCESS;
	}
	
	@Action(value="delDept",results={
			@Result(name="success",type="redirectAction",params={"namespace","/disease","actionName","diseaseSet"})
	})
	public String delDept() {
		diseaseService.del(id);
		return SUCCESS;
	}
	
	
	
	
	
	//get set
	

	
	public List<Dept> getList() {
		return list;
	}

	public void setList(List<Dept> list) {
		this.list = list;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
