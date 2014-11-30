package com.kaishengit.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Announce;
import com.kaishengit.pojo.Viewcount;
import com.kaishengit.service.AnnounceService;

@Namespace("/announce")
public class AnnounceAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AnnounceService announceService;
	
	private List<Viewcount> counts;
	
	private Announce announce;
	private String id;
	private String viewid;
	
	@Action(value="newAnnounce",results={
			@Result(name="success",location="/WEB-INF/content/announce/announce-new.jsp")
	})
	public String newAnnounce() {
		return SUCCESS;
	}
	
	@Action(value="pubAnnounce",results={
			@Result(name="success",type="redirectAction",params={"namespace","/","actionName","home","id","${id}"})
	})
	public String pub() {
		announceService.save(announce);
		return SUCCESS;
	}
	
	@Action(value="detail",results={
			@Result(name="success",location="/WEB-INF/content/announce/announce-detail.jsp")
	})
	public String detail() {
		counts = announceService.findAllcounts();
		announce = announceService.findById(id);
		announceService.saveViewcount(getCurrAccount(),announce);
		return SUCCESS;
	}
	
	
	
	//get set
	
	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getViewid() {
		return viewid;
	}

	public void setViewid(String viewid) {
		this.viewid = viewid;
	}

	public List<Viewcount> getCounts() {
		return counts;
	}

	public void setCounts(List<Viewcount> counts) {
		this.counts = counts;
	}
	
	
}
