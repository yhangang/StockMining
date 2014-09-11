package org.a805.service;

import java.util.List;

import com.hibernate.entity.TLoginLog;

public interface SystemService {
	
	public String save(TLoginLog tLoginLog);
	
	public List<TLoginLog> queryByPage(TLoginLog tLoginLog,int currentrecord,int pagesize);
	
	public int getCount(TLoginLog tLoginLog);


}
