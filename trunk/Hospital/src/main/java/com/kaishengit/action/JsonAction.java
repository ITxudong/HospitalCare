package com.kaishengit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.google.gson.Gson;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Disease;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.service.IllintroService;
import com.kaishengit.service.PatientService;
import com.kaishengit.util.AutoAgeSex;
import com.kaishengit.util.Circulate;
import com.kaishengit.util.PropertyFilter;

@Namespace("/")
public class JsonAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Inject
	private PatientService patientService;
	@Inject
	private DiseaseService diseaseService;
	@Inject
	private IllintroService illintroService;
	@Inject
	private DeptService deptService;
	
	private List<Patient> patients;
	private List<Disease> diseases;
	
	private Patient patient;
	private Dept dept;
	private String deptid;
	private String name;
	private String query;
	private String pid;
	
	//patient 基本信息说
	@Action(value="visitJson",results={
			@Result(name="none",type="json")
	})
	public String visitJson() {
		getHttpResponse().setContentType("application/json;charset=UTF-8");
		
		name = getHttpRequest().getParameter("patientName");
		patient = patientService.findByName(name);
		if(patient != null) {
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
		}
		return NONE;
	}

	//返回所有patient的信息
	@Action(value="patientsJson",results={
			@Result(name="none",type="json")
	})
	public String patientsJson() {
		getHttpResponse().setContentType("application/json;charset=UTF-8");
		
		List<Patient> patients = patientService.findAllLike(query);
		
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
	
	//chartjson 返回表格显示需要的数据
	
	@Action(value="chartJson",results={
			@Result(name="none",type="json")
	})
	public String chartJson() {
		
		/*  var json = {
        labels:['感冒','关节炎','腿疼','过敏','手足口病'],
        data:[24,56,29,98,78]
      }; */
		List<PropertyFilter> filterList = PropertyFilter.builderPropertyFilter(getHttpRequest());
		diseases = diseaseService.findAll();
		List<String> names = new ArrayList<String>();
		List<Long> nums = new ArrayList<Long>();
		
		for(Disease dis : diseases) {
			Long count = illintroService.count(filterList,dis);
			names.add(dis.getName());
			nums.add(count);
		}
		
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("labels", names);
		map.put("data", nums);
		
		try {
			toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
	//dept 和 disease级联
	@Action(value="link",results={
			@Result(name="none",type="json")
	})
	public String link() {
		dept = deptService.findById(deptid);
		diseases = dept.getDiseases();
		
		List<Object> list = new ArrayList<Object>();
		for(Disease d : diseases) {
			Map<String ,Object> map = new HashMap<String ,Object>();
			map.put("name", d.getName());
			map.put("deptid", d.getId());
			list.add(map);
		}
		try {
			toJson(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
	
	//根据身份证号自动判断  patient的年龄和性别
	@Action(value="autoJson",results={
			@Result(name="none",type="json")
	})
	public String auto() {
		String age = AutoAgeSex.getAge(pid);
		String sex = AutoAgeSex.getSex(pid);
		
		Map<String ,Object> out = new HashMap<String,Object>();
		out.put("age", age);
		out.put("sex", sex);
		
		try {
			toJson(out);
		} catch (Exception e) {
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
	
	
}
