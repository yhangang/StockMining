package org.a805.service.corpgovern;

import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

import com.hibernate.entity.TCompanyIndex;
import com.hibernate.entity.TCompanyIndexId;

public interface CompanyIndexService {

	public TCompanyIndex findById(TCompanyIndexId id);

	public void companyIndexDataDisplay(HttpServletResponse response,
			String[] selectedYears, TreeSet<String> selectedStockId,
			TreeSet<String> selectedIndexId);

}
