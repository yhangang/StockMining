package org.a805.struts2.action.corpgovern;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ClusteringService;
import org.a805.service.corpgovern.ExpCompanyService;
import org.a805.service.corpgovern.ExpIndexService;
import org.a805.service.corpgovern.ExpPeriodService;
import org.a805.service.corpgovern.ExperimentInformationService;
import org.a805.service.corpgovern.ShowGuiyueResultService;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ClusteringAction extends ActionSupport {
	private String expId;
	private String classes;
	private String clusteringMethod;
	private ClusteringService clusteringService;
	private ShowGuiyueResultService showGuiyueResultService;
	private ExperimentInformationService experimentInformationService;
	private ExpCompanyService expCompanyService;
	private ExpIndexService expIndexService;
	private ExpPeriodService expPeriodService;
	
	

	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getClusteringMethod() {
		return clusteringMethod;
	}

	public void setClusteringMethod(String clusteringMethod) {
		this.clusteringMethod = clusteringMethod;
	}

	public ClusteringService getClusteringService() {
		return clusteringService;
	}

	public void setClusteringService(ClusteringService clusteringService) {
		this.clusteringService = clusteringService;
	}

	public ShowGuiyueResultService getShowGuiyueResultService() {
		return showGuiyueResultService;
	}

	public void setShowGuiyueResultService(
			ShowGuiyueResultService showGuiyueResultService) {
		this.showGuiyueResultService = showGuiyueResultService;
	}

	public ExperimentInformationService getExperimentInformationService() {
		return experimentInformationService;
	}

	public void setExperimentInformationService(
			ExperimentInformationService experimentInformationService) {
		this.experimentInformationService = experimentInformationService;
	}

	
	public ExpCompanyService getExpCompanyService() {
		return expCompanyService;
	}

	public void setExpCompanyService(ExpCompanyService expCompanyService) {
		this.expCompanyService = expCompanyService;
	}

	public ExpIndexService getExpIndexService() {
		return expIndexService;
	}

	public void setExpIndexService(ExpIndexService expIndexService) {
		this.expIndexService = expIndexService;
	}

	public ExpPeriodService getExpPeriodService() {
		return expPeriodService;
	}

	public void setExpPeriodService(ExpPeriodService expPeriodService) {
		this.expPeriodService = expPeriodService;
	}

	public String ClusteringOfAgglomerate() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 获得选择的公司，指标，年份
		TreeSet<String> selectedStockId = new TreeSet<String>();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		ArrayList<String> selectedYears = new ArrayList<String>();
		int weight = 1;
		if (session.getAttribute("weight") != null) {
			weight = Integer.valueOf((String) session.getAttribute("weight"));
		}

/*		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");
		if (session.getAttribute("selectedYears") != null)
			selectedYears = (ArrayList<String>) session.getAttribute("selectedYears");*/
		
		selectedStockId = expCompanyService.getSelectedStockId(Integer.valueOf(expId));
		selectedIndexId = expIndexService.getSelectedSIndexId(Integer.valueOf(expId));
		selectedYears = expPeriodService.getSelectedYears(Integer.valueOf(expId));
		

		Map<String, String> stockIDAndGenome = showGuiyueResultService
				.getGenomes(selectedYears, selectedStockId, selectedIndexId,
						"binary", weight);

		Map<String, Map<String, String>> finalResult = clusteringService
				.ClusteringOfAgglomerate(stockIDAndGenome, Integer
						.parseInt(classes));
		
		expCompanyService.saveResults(Integer.valueOf(expId), finalResult);
		experimentInformationService.updateTime(Integer.valueOf(expId), new Date());
		
		
		request.setAttribute("finalResult", finalResult);
		
		
		

		
		

		return "success";
	}

}
