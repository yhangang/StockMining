package org.a805.service.corpgovern;

import java.util.Map;
import java.util.TreeSet;

public interface ExpCompanyService {
	public String save(int expId,TreeSet<String> selectedStockId);
	
	public String delete(int expId);
	
	public TreeSet<String> getSelectedStockId(int expId);
	
	public String saveResults(int expId,Map<String, Map<String, String>> finalResult);

}
