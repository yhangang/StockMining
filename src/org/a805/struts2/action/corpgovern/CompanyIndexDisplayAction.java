package org.a805.struts2.action.corpgovern;

import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.CompanyIndexService;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CompanyIndexDisplayAction extends ActionSupport {

	private CompanyIndexService companyIndexService;

	public CompanyIndexService getCompanyIndexService() {
		return companyIndexService;
	}

	public void setCompanyIndexService(CompanyIndexService companyIndexService) {
		this.companyIndexService = companyIndexService;
	}

	public void companyIndexDisplay() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获得选择的公司，指标，年份
		TreeSet<String> selectedStockId = new TreeSet<String>();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		String[] selectedYears = {};

		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");
		if (session.getAttribute("selectedYears") != null)
			selectedYears = (String[]) session.getAttribute("selectedYears");

		companyIndexService.companyIndexDataDisplay(response, selectedYears, selectedStockId, selectedIndexId);

	}

}
