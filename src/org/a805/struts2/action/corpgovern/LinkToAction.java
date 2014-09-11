package org.a805.struts2.action.corpgovern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LinkToAction extends ActionSupport {
	private String expId;
	
	
	
	public String getExpId() {
		return expId;
	}



	public void setExpId(String expId) {
		this.expId = expId;
	}



	public String toPeriodSelect(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		
		return "success";
	}
	
	public String toIndexSelect(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("expId", expId);
		
		
		return "success";
	}

}
