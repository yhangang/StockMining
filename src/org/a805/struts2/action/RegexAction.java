package org.a805.struts2.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.a805.tools.MakeCertPic;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class RegexAction extends ActionSupport {

	@Override
	public String execute() throws IOException{
		
			MakeCertPic make=new MakeCertPic();
			HttpServletResponse response=ServletActionContext.getResponse();
			
			String ma=make.getCertPic(0, 0, response.getOutputStream());
			ServletActionContext.getRequest().getSession().setAttribute("certCode", ma);
	
		return null;
	}


}
