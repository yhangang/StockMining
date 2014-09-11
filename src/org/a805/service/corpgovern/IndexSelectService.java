package org.a805.service.corpgovern;

import java.util.List;

import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;

public interface IndexSelectService {
	
	public List<TIndex> queryIndex(TIndex tIndex);
	
	public TIndex findIndexById(String indexId);

}
