package com.kaishengit.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.dao.IllintroDao;
import com.kaishengit.dao.ImgsDao;
import com.kaishengit.dao.VisitDao;
import com.kaishengit.pojo.Illintro;
import com.kaishengit.pojo.Imgs;
import com.kaishengit.pojo.Visit;
import com.kaishengit.util.PropertyFilter;

@Named
@Transactional
public class VisitService {

	@Inject
	private VisitDao visitDao;
	@Inject
	private IllintroDao illintroDao;
	@Inject
	private ImgsDao imgsDao;
	
	public List<Visit> search(List<PropertyFilter> filterList) {
		return visitDao.findAll(filterList);
	}
	
	public void save(Visit visit) {
		String createtime = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
		visit.setCreatetime(createtime);
	    
		visitDao.save(visit);
	}

	public List<Visit> findAll(String id) {
		return visitDao.findListByProperty("patient.id", id);
	}

	public Visit findById(String vid) {
		return visitDao.findById(vid);
	}

	public void save(Illintro illintro, Visit visit, String id) {
		String createtime = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
		visit.setCreatetime(createtime);
		
		Illintro ill = illintroDao.findById(id);
		
		ill.setRechecktime(illintro.getRechecktime());
		
		illintroDao.save(ill);
		
		visit.setCreatetime(createtime);
		visit.setIllintro(ill);
		visitDao.save(visit);
	}

	public void save(Illintro illintro, Visit visit) {
		
		String createtime = DateTime.now().toString("yyyy-MM-dd");
		visit.setCreatetime(createtime);
		
		illintro.setCreatetime(createtime);
		illintro.setState("дкея");
		illintroDao.save(illintro);
		
		visit.setCreatetime(createtime);
		visit.setIllintro(illintro);
		visitDao.save(visit);
		
	}

	public void save(Visit visit, Imgs imgs) {
		
		if(imgs != null) {
			String picname = imgs.getPicname();
			String[] img = picname.split(", ");
			
			for (int i = 0; i < img.length; i++) {
				Imgs im = new Imgs();
				im.setPicname(img[i]);
				im.setVisit(visit);
				imgsDao.save(im);
			}
		}
		
	}

	public void delVisit(String id) {
		visitDao.del(id);
	}

	public void update(Visit visit) {
		Visit v = visitDao.findById(visit.getId());
		v.setSymptom(visit.getSymptom());
		v.setYxcharacter(visit.getYxcharacter());
		v.setFinalresult(visit.getFinalresult());
		v.setCuremethod(visit.getCuremethod());
		visitDao.save(v);
	}

	public void delImg(String imgid) {
		imgsDao.del(imgid);
	}

}
