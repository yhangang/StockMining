package org.a805.tools;

import java.util.List;

public class PageView<T> {
	/** 分页数据 * */
	private List<T> resultlist;
	/** 总页数 * */
	private int totalpage;
	/** 当前页 * */
	private int currentpage = 1;
	/** 总记录数 * */
	private int totalrecord;
	/** 当前记录 * */
	private int currentrecord;
	/** 每页显示记录数 * */
	private int pagesize = 10;
	

	public PageView(int currentpage, int pagesize) {
		this.currentpage = currentpage;
		this.pagesize = pagesize;
		setCurrentrecord();
	}

	
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	
	public int getCurrentrecord() {
		return currentrecord;
	}
	public void setCurrentrecord() {
		this.currentrecord = (this.currentpage - 1) * this.pagesize;
	}
	
	

	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage() {
		this.totalpage = this.totalrecord % this.pagesize == 0 ? this.totalrecord
				/ this.pagesize
				: this.totalrecord / this.pagesize + 1;
	}

	
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage();
	}




}
