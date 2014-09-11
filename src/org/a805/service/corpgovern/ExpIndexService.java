package org.a805.service.corpgovern;

import java.util.TreeSet;

public interface ExpIndexService {
	public String save(int expId,TreeSet<String> selectedIndexId);
	
	public String delete(int expId);
	
	public TreeSet<String> getSelectedSIndexId(int expId);
}
