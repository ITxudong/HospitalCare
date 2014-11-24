package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Dept;
import com.kaishengit.service.DeptService;

@Namespace("/dept")
public class DeptAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private DeptService deptService;
	
	private Dept dept;
	
	private List<Dept> list;
	
	private String id;
	
	//dept settings
	@Action("deptSet")
	public String deptSet() {
		list = deptService.findAllDept();
		return SUCCESS;
	}
	
	@Action(value="newDept",results={
			@Result(name="success",location="/WEB-INF/content/dept/dept-new.jsp")
	})
	public String newDept() {
		return SUCCESS;
	}
	
	@Action(value="saveDept",results={
			@Result(name="success",type="redirectAction",params={"namespace","/dept","actionName","deptSet"})
	})
	public String saveDept() {
		deptService.save(dept);
		return SUCCESS;
	}
	
	@Action(value="update",results={
			@Result(name="success",location="/WEB-INF/content/dept/dept-update.jsp")
	})
	public String update() {
		dept = deptService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="updateDept",results={
			@Result(name="success",type="redirectAction",params={"namespace","/dept","actionName","deptSet"})
	})
	public String updateDept() {
		deptService.save(dept);
		return SUCCESS;
	}
	
	@Action(value="delDept",results={
			@Result(name="success",type="redirectAction",params={"namespace","/dept","actionName","deptSet"})
	})
	public String delDept() {
		deptService.del(id);
		return SUCCESS;
	}
	
	
	
	//get set
	

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Dept> getList() {
		return list;
	}

	public void setList(List<Dept> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
