package org.a805.struts2.action.corpgovern;

import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ExpIndexService;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExpIndexAction extends ActionSupport{
	private ExpIndexService expIndexService;
	private String expId;
	public ExpIndexService getExpIndexService() {
		return expIndexService;
	}
	public void setExpIndexService(ExpIndexService expIndexService) {
		this.expIndexService = expIndexService;
	}
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
	}
	
	public String save(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		
		// 获取已选指标id
		TreeSet<String> selectedIndexId = (TreeSet<String>) session
		.getAttribute("selectedIndexId");
		
		expIndexService.save(Integer.parseInt(expId), selectedIndexId);
		
		return "success";
	}
	

}
