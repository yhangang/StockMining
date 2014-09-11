package org.a805.struts2.action.corpgovern;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GuiyueSubmitAction extends ActionSupport{
	private String weight;
	private String guiyueMethod;
	private String expId;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
	public String getGuiyueMethod() {
		return guiyueMethod;
	}

	public void setGuiyueMethod(String guiyueMethod) {
		this.guiyueMethod = guiyueMethod;
	}
	

	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("weight", weight);
		session.setAttribute("guiyueMethod", guiyueMethod);
		
		return "success";
	}
	
	

}
