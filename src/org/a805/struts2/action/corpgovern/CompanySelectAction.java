package org.a805.struts2.action.corpgovern;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.CompanySelectService;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;
import com.opensymphony.xwork2.ActionSupport;

public class CompanySelectAction extends ActionSupport {
	private TCompany company;
	private CompanySelectService companySelectService;

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}



	public CompanySelectService getCompanySelectService() {
		return companySelectService;
	}

	public void setCompanySelectService(CompanySelectService companySelectService) {
		this.companySelectService = companySelectService;
	}

	public void queryCompany() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		String classificationOfCsrc = request.getParameter("classificationOfCsrc");
		String classificationOfGics = request.getParameter("classificationOfGics");
		String area = request.getParameter("area");
		
		TCompany tcompany = new TCompany();
		tcompany.setClassificationOfCsrc(classificationOfCsrc);
		tcompany.setClassificationOfGics(classificationOfGics);
		tcompany.setArea(area);
		

		List<TCompany> listTCompany = companySelectService.queryCompany(tcompany);

		printCompanyQueryResult(listTCompany);
	}

	/**
	 * 选择公司
	 */
	public void selectCompany() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		// 接收页面传来的参数
		String[] companys = request.getParameterValues("left");

		// 被选股票id的集合
		TreeSet<String> selectedStockId = new TreeSet<String>();
		// 获取已选股票id
		if (session.getAttribute("selectedStockId") != null)
			selectedStockId = (TreeSet<String>) session
					.getAttribute("selectedStockId");

		// 添加本次选择的股票id
		for (int i = 0; i < companys.length; i++) {
			selectedStockId.add(companys[i]);
		}
		// 将结果更新到session
		session.setAttribute("selectedStockId", selectedStockId);

		printSelectedCompanyHTML(selectedStockId);
	}
	/**
	 * 取消选择的公司
	 */
	public void unSelectCompany() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		// 接收页面传来的参数
		String[] companys = request.getParameterValues("right");
		// 获取已选股票id
		TreeSet<String> selectedStockId = (TreeSet<String>) session
		.getAttribute("selectedStockId");
		// 删除本次选择的股票id
		for (int i = 0; i < companys.length; i++) {
			selectedStockId.remove(companys[i]);
		}
		// 将结果更新到session
		session.setAttribute("selectedStockId", selectedStockId);

		printSelectedCompanyHTML(selectedStockId);
	}
	/**
	 * 清空选择的公司
	 */
	public void clearAllCompany() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		
		// 获取已选股票id
		TreeSet<String> selectedStockId = (TreeSet<String>) session
		.getAttribute("selectedStockId");
		// 清空选择的股票id
		selectedStockId.clear();
		
		// 将结果更新到session
		session.setAttribute("selectedStockId", selectedStockId);
		
		printSelectedCompanyHTML(selectedStockId);
		
	}
	/**
	 * 刷新
	 */
	public void refreshCompany() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		
		// 获取已选股票id
		TreeSet<String> selectedStockId = (TreeSet<String>) session
		.getAttribute("selectedStockId");
		
		printSelectedCompanyHTML(selectedStockId);
		
	}
	/**
	 * 动态生成查询结果的HTML代码
	 * @param selectedStockId
	 */
	public void printCompanyQueryResult(List<TCompany> listTCompany){
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response
					.getWriter()
					.write(
							"<select name='left' id='left' size='20' multiple class='selectStyle'>");
			for (TCompany company : listTCompany) {
				response.getWriter().write(
						"<option value='" + company.getStockId().toString() + "'>" + company.getStockId().toString() + "   " + company.getStockShortName().toString()
								+ "</option>");
			}
			response.getWriter().write("</select>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 动态生成选择结果的HTML代码
	 * @param selectedStockId
	 */
	public void printSelectedCompanyHTML(TreeSet<String> selectedStockId){
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response
					.getWriter()
					.write(
							"<select name='right' id='right' size='20' multiple class='selectStyle'>");
			for (String stockId : selectedStockId) {
				response.getWriter().write(
						"<option value='" + stockId + "'>" + stockId + "   " + companySelectService.findCompanyById(stockId).getStockShortName().toString()
								+ "</option>");
			}
			response.getWriter().write("</select>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
