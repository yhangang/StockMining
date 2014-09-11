package org.a805.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.a805.service.SystemService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TLoginLogDAO;
import com.hibernate.entity.TLoginLog;

public class SystemServiceImpl implements SystemService {
	private TLoginLogDAO loginLogDAO;

	public TLoginLogDAO getLoginLogDAO() {
		return loginLogDAO;
	}

	public void setLoginLogDAO(TLoginLogDAO loginLogDAO) {
		this.loginLogDAO = loginLogDAO;
	}

	public String save(TLoginLog loginLog) {
		// TODO Auto-generated method stub
		try {
			loginLogDAO.getSession().clear();
			loginLogDAO.save(loginLog);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	/**
	 * 分页查询
	 */
	public List<TLoginLog> queryByPage(TLoginLog loginLog, int currentrecord,
			int pagesize) {
		// TODO Auto-generated method stub
		Criteria criteria = loginLogDAO.getCriteria();

		criteria.setFirstResult(currentrecord);
		criteria.setMaxResults(pagesize);

		if (loginLog.getUsername() != null
				&& "".equals(loginLog.getUsername()) == false) {
			criteria.add(Restrictions.like("username", loginLog.getUsername(),
					MatchMode.ANYWHERE));
		}
		if (loginLog.getRealname() != null
				&& "".equals(loginLog.getRealname()) == false) {
			criteria.add(Restrictions.like("realname", loginLog.getRealname(),
					MatchMode.ANYWHERE));
		}

		List<TLoginLog> listTLoginLog = (List<TLoginLog>) loginLogDAO
				.findByCriteria(criteria);

		return listTLoginLog;
	}

	public int getCount(TLoginLog loginLog) {
		// TODO Auto-generated method stub
		List<TLoginLog> listTLoginLog = new ArrayList<TLoginLog>();
		listTLoginLog = queryByPage(loginLog,0,Integer.MAX_VALUE);
			
		return listTLoginLog.size();
	}

	/*
	 * public static void main(String args[]) { UserServiceImpl test = new
	 * UserServiceImpl(); TUser tuser = new TUser(); tuser.setId(2);
	 * tuser.setUsername("xxx"); tuser.setPwd("xxx");
	 * tuser.setRealname("天才的低调"); tuser.setRoleId("000001");
	 * tuser.setCollege("天津大学");
	 * 
	 * test.save(tuser);
	 *  }
	 */

}
