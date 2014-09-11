package org.a805.struts2.action.corpgovern;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ExpPeriodService;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TExpPeriod;
import com.opensymphony.xwork2.ActionSupport;

public class PeriodSelectAction extends ActionSupport {
	private ExpPeriodService expPeriodService;
	private String startyear;
	private String endyear;
	private String expId;

	public ExpPeriodService getExpPeriodService() {
		return expPeriodService;
	}

	public void setExpPeriodService(ExpPeriodService expPeriodService) {
		this.expPeriodService = expPeriodService;
	}
	
	
	public String getStartyear() {
		return startyear;
	}

	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}

	public String getEndyear() {
		return endyear;
	}

	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}

	
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		ArrayList<String> selectedYears = new ArrayList<String>();
		// 循环年份，得到年份的集合
		startyear = startyear.substring(0, 4) + "-01-01";
		endyear = endyear.substring(0, 4) + "-01-01";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(sdf.parse(startyear));
			cal2.setTime(sdf.parse(endyear));

			while (cal2.after(cal) || cal2.equals(cal)) {
				selectedYears.add(sdf.format(cal.getTime()).substring(0, 4)
						+ "-00-00");
				cal.add(Calendar.YEAR, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.setAttribute("selectedYears", selectedYears);
		
		
		TExpPeriod entity = new TExpPeriod();
		entity.setExpId(Integer.valueOf(expId));
		entity.setStartYear(startyear);
		entity.setEndYear(endyear);
		
		expPeriodService.save(entity);
		
		
		return "success";
	}

}
