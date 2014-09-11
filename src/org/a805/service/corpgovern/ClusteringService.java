package org.a805.service.corpgovern;

import java.util.Map;
import java.util.Set;

public interface ClusteringService {
	public int calculateDIstance(String genome1,String genome2);
	
	public Map<String, Map<String,String>> ClusteringOfAgglomerate(Map<String, String> map,int classes);

}
