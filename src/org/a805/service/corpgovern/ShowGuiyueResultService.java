package org.a805.service.corpgovern;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

public interface ShowGuiyueResultService {
	public void showGuiyueResult(HttpServletResponse response,
			String[] selectedYears, TreeSet<String> selectedStockId,
			TreeSet<String> selectedIndexId,String numberFormat,int weight);
	
	public Map<String,String> getGenomes(ArrayList<String> selectedYears, TreeSet<String> selectedStockId,
			TreeSet<String> selectedIndexId,String numberFormat,int weight);

}
