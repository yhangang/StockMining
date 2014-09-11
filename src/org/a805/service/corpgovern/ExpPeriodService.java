package org.a805.service.corpgovern;

import java.util.ArrayList;
import java.util.Date;

import com.hibernate.entity.TExpPeriod;

public interface ExpPeriodService {
	public String save(TExpPeriod entity);
	
	public ArrayList<String> getSelectedYears(int expId);
	

}
