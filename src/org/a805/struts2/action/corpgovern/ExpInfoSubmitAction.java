package org.a805.struts2.action.corpgovern;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.a805.service.corpgovern.ExperimentInformationService;
import org.apache.struts2.ServletActionContext;

import com.hibernate.entity.TExperimentInformation;
import com.hibernate.entity.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class ExpInfoSubmitAction extends ActionSupport {
	private String expName;
	private String power;
	private ExperimentInformationService experimentInformationService;

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}



	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public ExperimentInformationService getExperimentInformationService() {
		return experimentInformationService;
	}

	public void setExperimentInformationService(
			ExperimentInformationService experimentInformationService) {
		this.experimentInformationService = experimentInformationService;
	}
	
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		ArrayList<String> selectedYears = new ArrayList<String>();

		// 循环年份，得到年份的集合
		/*startyear = startyear.substring(0, 4) + "-01-01";
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
		}*/
		TUser tUser = (TUser)session.getAttribute("loginer");
		
		TExperimentInformation tExperimentInformation = new TExperimentInformation();
		tExperimentInformation.setCreateTime(new Date());
		tExperimentInformation.setUpdateTime(new Date());
		tExperimentInformation.setExpName(expName);
		tExperimentInformation.setPower(power);
		tExperimentInformation.setUserId(tUser.getId());
		
		String flag = experimentInformationService.save(tExperimentInformation);
		
		if("success".equals(flag)){
			request.setAttribute("flag", "success");
		}
		else{
			request.setAttribute("flag", "error");	
		}
		
		

		return "success";
		
	}

	public static void main(String a[]) {
		String t1 = "2010-11-05";
		String t2 = "2012-03-03";

		t1 = t1.substring(0, 4) + "-01-01";
		t2 = t2.substring(0, 4) + "-01-01";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(sdf.parse(t1));
			cal2.setTime(sdf.parse(t2));

			while (cal2.after(cal) || cal2.equals(cal)) {
				System.out.println(sdf.format(cal.getTime()).substring(0, 4));
				cal.add(Calendar.YEAR, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
