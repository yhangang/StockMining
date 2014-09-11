package org.a805.struts2.action.corpgovern;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ShowGuiyueResultService;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ShowGuiyueResultAction extends ActionSupport {
	private ShowGuiyueResultService showGuiyueResultService;

	public ShowGuiyueResultService getShowGuiyueResultService() {
		return showGuiyueResultService;
	}

	public void setShowGuiyueResultService(
			ShowGuiyueResultService showGuiyueResultService) {
		this.showGuiyueResultService = showGuiyueResultService;
	}

	public void showGuiyueResult() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获得选择的公司，指标，年份
		TreeSet<String> selectedStockId = new TreeSet<String>();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		String[] selectedYears = {};
		int weight = 1;
		if (session.getAttribute("weight") != null) {
			weight = Integer.valueOf((String) session.getAttribute("weight"));
		}

		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");
		if (session.getAttribute("selectedYears") != null)
			selectedYears = (String[]) session.getAttribute("selectedYears");

		showGuiyueResultService.showGuiyueResult(response, selectedYears,
				selectedStockId, selectedIndexId, "binary", weight);

	}

	public void showGuiyueResultHexadecimal() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获得选择的公司，指标，年份
		TreeSet<String> selectedStockId = new TreeSet<String>();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		String[] selectedYears = {};
		int weight = 1;
		if (session.getAttribute("weight") != null) {
			weight = Integer.valueOf((String) session.getAttribute("weight"));
		}

		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");
		if (session.getAttribute("selectedYears") != null)
			selectedYears = (String[]) session.getAttribute("selectedYears");

		showGuiyueResultService.showGuiyueResult(response, selectedYears,
				selectedStockId, selectedIndexId, "hexadecimal", weight);

		/*
		 * 测试getGenomes()函数用的
		 * Map<String, String> genomesMap = new HashMap<String, String>();
		 * genomesMap = showGuiyueResultService.getGenomes(selectedYears,
		 * selectedStockId, selectedIndexId, "hexadecimal", weight); Iterator it =
		 * genomesMap.entrySet().iterator(); while(it.hasNext()){ Map.Entry<String,
		 * String> map = (Map.Entry<String, String> )it.next();
		 * System.out.println(map.getValue()); }
		 */

	}

}
