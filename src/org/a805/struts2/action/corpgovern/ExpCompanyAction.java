package org.a805.struts2.action.corpgovern;

import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ExpCompanyService;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ExpCompanyAction extends ActionSupport{
	private ExpCompanyService expCompanyService;
	private String expId;
	
	
	public ExpCompanyService getExpCompanyService() {
		return expCompanyService;
	}


	public void setExpCompanyService(ExpCompanyService expCompanyService) {
		this.expCompanyService = expCompanyService;
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
		
		// 获取已选股票id
		TreeSet<String> selectedStockId = (TreeSet<String>) session
		.getAttribute("selectedStockId");
		
		expCompanyService.save(Integer.parseInt(expId), selectedStockId);
		
		return "success";
	}

}
