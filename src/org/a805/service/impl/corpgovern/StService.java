package org.a805.service.impl.corpgovern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.hibernate.dao.TStCompanyDAO;
import com.hibernate.entity.TStCompany;
import com.hibernate.entity.TStCompanyId;

public class StService {
	
	
	public static boolean isST(String year , String stockId){
		TStCompanyDAO dao = new TStCompanyDAO();

		TStCompanyId id = new TStCompanyId();
		id.setYear(year);
		id.setStockId(stockId);
		
		TStCompany entity = dao.findById(id);
		
		if(entity == null){
			return false;
		}
		
		return true;
	}
	
	public static int countST(Map<String, String> map,ArrayList<String> selectedYears) {
		TStCompanyDAO dao = new TStCompanyDAO();
		int count = 0;
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			for(String year:selectedYears){
				if(StService.isST(year.substring(0, 4),entry.getKey())){
					count++;
					break;
				}
			}	
		}
		
		
		return count;
	}
	
	public static void main(String a[]){
	
		
	}

}
