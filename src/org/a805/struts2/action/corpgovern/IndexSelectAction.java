package org.a805.struts2.action.corpgovern;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.IndexSelectService;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;
import com.opensymphony.xwork2.ActionSupport;

public class IndexSelectAction extends ActionSupport {
	private TIndex index;
	private IndexSelectService indexSelectService;




	public TIndex getIndex() {
		return index;
	}

	public void setIndex(TIndex index) {
		this.index = index;
	}



	public IndexSelectService getIndexSelectService() {
		return indexSelectService;
	}

	public void setIndexSelectService(IndexSelectService indexSelectService) {
		this.indexSelectService = indexSelectService;
	}

	public void queryIndex() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		
		String indexType = request.getParameter("indexType");
		
		TIndex tIndex = new TIndex();
		tIndex.setIndexType(indexType);
		

		List<TIndex> listTIndex = indexSelectService.queryIndex(tIndex);
		
		printIndexQueryResult(listTIndex);

		
	}
	
	/**
	 * 选择指标
	 */
	public void selectIndex() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		// 接收页面传来的参数
		String[] indexes = request.getParameterValues("left");

		// 被选股票id的集合
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		// 获取已选股票id
		if (session.getAttribute("selectedIndexId") != null)
			selectedIndexId = (TreeSet<String>) session
					.getAttribute("selectedIndexId");

		// 添加本次选择的股票id
		for (int i = 0; i < indexes.length; i++) {
			selectedIndexId.add(indexes[i]);
		}
		// 将结果更新到session
		session.setAttribute("selectedIndexId", selectedIndexId);

		printSelectedIndexHTML(selectedIndexId);
	}
	
	/**
	 * 取消选择的指标
	 */
	public void unSelectIndex() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		// 接收页面传来的参数
		String[] indexes = request.getParameterValues("right");
		// 获取已选股票id
		TreeSet<String> selectedIndexId = (TreeSet<String>) session
		.getAttribute("selectedIndexId");
		// 删除本次选择的股票id
		for (int i = 0; i < indexes.length; i++) {
			selectedIndexId.remove(indexes[i]);
		}
		// 将结果更新到session
		session.setAttribute("selectedIndexId", selectedIndexId);

		printSelectedIndexHTML(selectedIndexId);
	}
	
	/**
	 * 清空选择的指标
	 */
	public void clearAllIndex() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		
		// 获取已选股票id
		TreeSet<String> selectedIndexId = (TreeSet<String>) session
		.getAttribute("selectedIndexId");
		// 清空选择的股票id
		selectedIndexId.clear();
		
		// 将结果更新到session
		session.setAttribute("selectedIndexId", selectedIndexId);
		
		printSelectedIndexHTML(selectedIndexId);
		
	}
	/**
	 * 刷新
	 */
	public void refreshIndex() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		response.setCharacterEncoding("UTF-8");
		
		// 获取已选股票id
		TreeSet<String> selectedIndexId = (TreeSet<String>) session
		.getAttribute("selectedIndexId");
		
		printSelectedIndexHTML(selectedIndexId);
		
	}
	/**
	 * 动态生成查询结果的HTML代码
	 * @param selectedStockId
	 */
	public void printIndexQueryResult(List<TIndex> listTIndex){
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response
					.getWriter()
					.write(
							"<select name='left' id='left' size='20' multiple class='selectStyle'>");
			for (TIndex index : listTIndex) {
				response.getWriter().write(
						"<option value='" + index.getIndexId().toString() + "'>" + index.getIndexId().toString()+ "   " + index.getIndexName().toString()
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
	public void printSelectedIndexHTML(TreeSet<String> selectedIndexId){
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response
					.getWriter()
					.write(
							"<select name='right' id='right' size='20' multiple class='selectStyle'>");
			for (String indexId : selectedIndexId) {
				response.getWriter().write(
						"<option value='" + indexId + "'>" + indexId + "   " + indexSelectService.findIndexById(indexId).getIndexName().toString()
								+ "</option>");
			}
			response.getWriter().write("</select>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
