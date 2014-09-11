package org.a805.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hibernate.dao.TCompanyIndexDAO;
import com.hibernate.entity.TCompanyIndex;
import com.hibernate.entity.TCompanyIndexId;

public class DateFormatTransfer {
	
	//yyyy-MM-dd HH:mm:ss

	public static Date stringToDate(String date, String dateFormat) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date parsedDate = null;
		try {
			parsedDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parsedDate;

	}

	public static String dateToString(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		return sdf.format(date);
	}
	public static void main(String a[]){
		TCompanyIndexDAO companyIndexDAO =new TCompanyIndexDAO();
		
		TCompanyIndexId tCompanyIndexId = new TCompanyIndexId();
		tCompanyIndexId.setIndexDate("2004-00-00");
		tCompanyIndexId.setStockId("000002");
		tCompanyIndexId.setIndexId("000001");
		
		TCompanyIndex tCompanyIndex = companyIndexDAO.findById(tCompanyIndexId);
		
		System.out.println(tCompanyIndex.getIndexValue());
		
	}

}
