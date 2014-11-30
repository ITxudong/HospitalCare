package com.kaishengit.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.pojo.Illintro;
import com.kaishengit.pojo.Imgs;
import com.kaishengit.pojo.Visit;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.service.IllintroService;
import com.kaishengit.service.PatientService;
import com.kaishengit.service.VisitService;
import com.kaishengit.util.PropertyFilter;

@Namespace("/visit")
public class VisitAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Inject
	PatientService patientService;
	@Inject
	DeptService deptService;
	@Inject
	VisitService visitService;
	@Inject
	DiseaseService diseaseService;
	@Inject
	IllintroService illintroService;
	
	private List<Patient> patients;
	private List<Dept> depts;
	private List<Visit> visits;
	private List<Disease> diseases;
	private List<Illintro> illintros;
	
	private Visit visit;
	private Illintro illintro;
	private Imgs imgs;
	private String id;
	private File file; 
	private String fileFileName;
	private String fileContentType;
	
	@Action(value="visitlist",results={
			@Result(name="success",location="/WEB-INF/content/visit/visit-list.jsp")
	})
	public String visitlist() {
		List<PropertyFilter> filterList = PropertyFilter.builderPropertyFilter(getHttpRequest());
		illintros = illintroService.search(filterList);
		return SUCCESS;
	}
	
	@Action(value="newVisit",results={
			@Result(name="success",location="/WEB-INF/content/visit/visit-new.jsp")
	})
	public String newVisit() {
		depts = deptService.findAllDept();
		diseases = diseaseService.findAll();
		return SUCCESS;
	}

	@Action(value="saveVisit",results={
			@Result(name="success",type="redirectAction",params={"namespace","/visit","actionName","visitlist"})
	})
	public String saveVisit() {
		
		visitService.save(illintro,visit);
		visitService.save(visit,imgs);
		
		return SUCCESS;
	}
	
	@Action(value="visitDetail",results={
			@Result(name="success",location="/WEB-INF/content/visit/visit-detail.jsp")
	})
	public String visitDetail() {
		illintro = illintroService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="newReply",results={
			@Result(name="success",location="/WEB-INF/content/visit/new-reply.jsp")
	})
	public String newReply() {
		illintro = illintroService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="saveReply",results={
			@Result(name="success",type="redirectAction",params={"namespace","/visit","actionName","visitDetail","id","${id}"})
	})
	public String saveReply() {
		visitService.save(illintro,visit,id);
		return SUCCESS;
	}
	
	//illintro ²¡Çé¼ò½éÏà¹Ø²Ù×÷£¨ÐÞ¸Ä£¬É¾³ý£©
	@Action(value="updateIllintro",results={
			@Result(name="success",location="/WEB-INF/content/visit/illintro-update.jsp")
	})
	public String updateIllintro() {
		depts = deptService.findAllDept();
		diseases = diseaseService.findAll();
		illintro = illintroService.findById(id);
		return SUCCESS;
	}
	
	@Action(value="saveIllintro",results={
			@Result(name="success",type="redirectAction",params={"namespace","/visit","actionName","visitDetail","id","${id}"})
	})
	public String saveIllintro() {
		illintroService.update(illintro);
		return SUCCESS;
	}
	
	//Í¼Æ¬ÉÏ´«
	@Action("upload")
	public String uploader() {
		try {
			IOUtils.copy(new FileInputStream(file), new FileOutputStream(new File("C:/upload/",fileFileName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//¼ÓÔØÍ¼Æ¬
	@Action("load")
	public String load() {
		
		try {
			downloadFile("C:/upload/"+fileFileName, fileFileName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	//ÏÂÔØºÍÔ¤ÀÀÍ¼Æ¬
	@Action("download")
	public String download() {
		
		try {
			downloadFile("C:/upload", fileFileName, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
	
	
	//get set
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public Illintro getIllintro() {
		return illintro;
	}

	public List<Illintro> getIllintros() {
		return illintros;
	}

	public void setIllintros(List<Illintro> illintros) {
		this.illintros = illintros;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Imgs getImgs() {
		return imgs;
	}

	public void setImgs(Imgs imgs) {
		this.imgs = imgs;
	}

	
	
	
	
}
