package org.a805.service.corpgovern;

import java.util.List;

import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;

public interface CompanySelectService {
	public List<TCompany> queryCompany(TCompany tCompany);
	
	public TCompany findCompanyById(String stockId);
	


}
