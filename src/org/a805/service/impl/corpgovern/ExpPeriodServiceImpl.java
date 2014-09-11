package org.a805.service.impl.corpgovern;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;

import org.a805.service.corpgovern.ExpPeriodService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TExpCompanyDAO;
import com.hibernate.dao.TExpPeriodDAO;
import com.hibernate.entity.TExpCompany;
import com.hibernate.entity.TExpPeriod;

public class ExpPeriodServiceImpl implements ExpPeriodService {
	TExpPeriodDAO expPeriodDAO;
	
	

	public TExpPeriodDAO getExpPeriodDAO() {
		return expPeriodDAO;
	}



	public void setExpPeriodDAO(TExpPeriodDAO expPeriodDAO) {
		this.expPeriodDAO = expPeriodDAO;
	}



	public String save(TExpPeriod entity) {
		// TODO Auto-generated method stub
		try {
			expPeriodDAO.getSession().clear();
			TExpPeriod entity2 = new TExpPeriod();
			entity2.setExpId(entity.getExpId());
			expPeriodDAO.delete(entity2);
			expPeriodDAO.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public ArrayList<String> getSelectedYears(int expId) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		TExpPeriodDAO expPeriodDAO = new TExpPeriodDAO();

		TExpPeriod entity = expPeriodDAO.findById(expId);
		
		String startyear = entity.getStartYear();
		String endyear = entity.getEndYear();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(sdf.parse(startyear));
			cal2.setTime(sdf.parse(endyear));

			while (cal2.after(cal) || cal2.equals(cal)) {
				list.add(sdf.format(cal.getTime()).substring(0, 4)
						+ "-00-00");
				cal.add(Calendar.YEAR, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		


		return list;
	}
	
	public static void main(String a[]){
		ExpPeriodServiceImpl test = new ExpPeriodServiceImpl();
		System.out.println(test.getSelectedYears(1));
		
	}





}
