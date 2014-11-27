package com.kaishengit.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/chart")
public class ChartAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Action(value="chartlist",results={
			@Result(name="success",location="/WEB-INF/content/chart/chart-list.jsp")
	})
	public String chartlist() {
		return SUCCESS;
	}
	
	
	
	
}
