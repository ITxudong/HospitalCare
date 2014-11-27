package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Illintro;
import com.kaishengit.service.IllintroService;
import com.kaishengit.util.PropertyFilter;

@Namespace("/notify")
public class NotifyAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IllintroService illintroService;
	
	private Illintro illintro;
	
	private List<Illintro> illintros;
	
	private String id;
	
	@Action(value="notifylist",results={
			@Result(name="success",location="/WEB-INF/content/notify/notify-list.jsp")
	})
	public String notifylist() {
		List<PropertyFilter> filterList = PropertyFilter.builderPropertyFilter(getHttpRequest());
		illintros = illintroService.search(filterList);
		return SUCCESS;
	}

	//get set 
	
	public Illintro getIllintro() {
		return illintro;
	}

	public void setIllintro(Illintro illintro) {
		this.illintro = illintro;
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
