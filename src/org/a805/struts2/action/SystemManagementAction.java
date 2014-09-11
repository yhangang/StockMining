package org.a805.struts2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.a805.service.SystemService;
import org.a805.tools.PageView;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TLoginLog;
import com.opensymphony.xwork2.ActionSupport;

public class SystemManagementAction extends ActionSupport {
	public static final int PAGESIZE = 10;
	public static final int FIRSTPAGE = 1;

	private TLoginLog loginlog;
	private SystemService systemService;
	private int currentPage = FIRSTPAGE;

	public TLoginLog getLoginlog() {
		return loginlog;
	}

	public void setLoginlog(TLoginLog loginlog) {
		this.loginlog = loginlog;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();

		PageView<TLoginLog> pageview = new PageView<TLoginLog>(currentPage,
				PAGESIZE);

		pageview.setResultlist(systemService.queryByPage(loginlog, pageview
				.getCurrentrecord(), pageview.getPagesize()));
		pageview.setTotalrecord(systemService.getCount(loginlog));
		request.setAttribute("queryResult", pageview);
		request.setAttribute("loginlog", loginlog);

		return "success";
	}

}
