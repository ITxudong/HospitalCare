package com.kaishengit.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.kaishengit.pojo.Account;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public HttpServletRequest getHttpRequest() {
		
		return ServletActionContext.getRequest();
		
	}
	
	public HttpServletResponse getHttpResponse() {
		return ServletActionContext.getResponse();
	}
	
	//json
	
	public void toJson(Object obj) throws Exception {
        
		HttpServletResponse response = getHttpResponse();
		response.setContentType("application/json;charset=UTF-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	}
	
	
	public static Map<String,String> mimeType = new HashMap<String, String>();
	static {
		mimeType.put(".pdf", "application/pdf");
		mimeType.put(".json", "application/json");
		mimeType.put(".doc","application/msword");
		mimeType.put(".jpg","image/jpeg");
		mimeType.put(".jpeg","image/jpeg");
		mimeType.put(".jpe","image/jpeg");
		mimeType.put(".xls","application/vnd.ms-excel");
		mimeType.put(".zip","application/zip");
		mimeType.put(".wps","application/vnd.ms-works");
		mimeType.put(".gif","image/gif");
		mimeType.put(".mp3","audio/mpeg");
		//application/octet-stream
	}

	public void downloadFile(String filePath,String downloadFileName, boolean b) throws Exception{
		HttpServletResponse response = getHttpResponse();
		
		if(!b){
			downloadFileName = new String(downloadFileName.getBytes("UTF-8"),"ISO8859-1");
			response.addHeader("Content-Disposition", "attachment;filename=\""+downloadFileName+"\"");
		}
		
		String fileType = filePath.substring(filePath.lastIndexOf("."));
		if(mimeType.containsKey(fileType)) {
			response.setContentType(mimeType.get(fileType));
		} else {
		//<!--û�еĻ�����Ϊ��2����-->
			response.setContentType("application/octet-stream");
		}
		
		OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(new File(filePath));
		
		IOUtils.copy(in, out);
		out.flush();
		out.close();
		in.close();
	}

	public Account getCurrAccount() {
		return (Account) getHttpRequest().getSession().getAttribute("currAccount");
	}
	
	//�ж��Ƿ�Ϊ����Ա
	public Boolean isAdmin() {
		if("����Ա".equals(getCurrAccount().getType())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	//�ж��Ƿ�Ϊ���棬�����ʼ��Ĵ�����
	public Boolean isCreater(Object obj) {
		return true;
	}
	
	
	
	
}
