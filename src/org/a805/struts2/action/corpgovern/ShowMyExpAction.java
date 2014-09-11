package org.a805.struts2.action.corpgovern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ExperimentInformationService;
import org.a805.tools.PageView;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TExperimentInformation;
import com.hibernate.entity.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class ShowMyExpAction extends ActionSupport {
	public static final int PAGESIZE = 10;
	public static final int FIRSTPAGE = 1;

	private ExperimentInformationService experimentInformationService;
	private TExperimentInformation experimentInformation;
	private int currentPage = FIRSTPAGE;

	public TExperimentInformation getExperimentInformation() {
		return experimentInformation;
	}

	public void setExperimentInformation(
			TExperimentInformation experimentInformation) {
		this.experimentInformation = experimentInformation;
	}

	public ExperimentInformationService getExperimentInformationService() {
		return experimentInformationService;
	}

	public void setExperimentInformationService(
			ExperimentInformationService experimentInformationService) {
		this.experimentInformationService = experimentInformationService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String query() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		TUser tUser = (TUser)session.getAttribute("loginer");
		//仅能查询到自己的实验
		experimentInformation.setUserId(tUser.getId());

		PageView<TExperimentInformation> pageview = new PageView<TExperimentInformation>(currentPage,
				PAGESIZE);
		
		pageview.setResultlist(experimentInformationService.queryByPage(experimentInformation, pageview
				.getCurrentrecord(), pageview.getPagesize()));
		pageview.setTotalrecord(experimentInformationService.getCount(experimentInformation));
		
		request.setAttribute("queryResult", pageview);
		request.setAttribute("experimentInformation", experimentInformation);

		return "success";
	}

}
