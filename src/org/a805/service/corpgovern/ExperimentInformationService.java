package org.a805.service.corpgovern;

import java.util.Date;
import java.util.List;

import com.hibernate.entity.TExperimentInformation;
import com.hibernate.entity.TLoginLog;

public interface ExperimentInformationService {
	public String save(TExperimentInformation tExperimentInformation);
	
	public List<TExperimentInformation> queryByPage(TExperimentInformation tExperimentInformation,int currentrecord,int pagesize);
	
	public List<TExperimentInformation> queryByPage(int currentrecord,int pagesize);
	
	public int getCount(TExperimentInformation tExperimentInformation);
	
	public String updateTime(int expId,Date date);

}
