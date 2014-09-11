package org.a805.service;

import java.util.List;

import com.hibernate.entity.TUser;

public interface UserService {
	public TUser checkUser(String username);
	
	public String changePwd(TUser tuser,String oldPwd,String newPwd);
	
	public List<TUser> queryByPage(TUser tuser,int currentrecord,int pagesize);
	
	public int getCount(TUser tuser);
	
	public String delete(int id);
	
	public String update(TUser tuser);
	
	public TUser findTUserById(int id);
	
	public String save(TUser tuser);
	
	public boolean isExist(String username);
	


}
