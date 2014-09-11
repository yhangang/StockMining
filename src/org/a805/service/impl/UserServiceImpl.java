package org.a805.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.a805.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TRoleDAO;
import com.hibernate.dao.TUserDAO;
import com.hibernate.entity.TUser;

public class UserServiceImpl implements UserService {
	private TUserDAO userDAO;

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TUser checkUser(String username) {
		// TODO Auto-generated method stub
		TUser tUser = new TUser();
		List list = null;
		list = userDAO.findByUsername(username);
		Iterator it = list.iterator();
		if (it.hasNext()) {
			tUser = (TUser) it.next();
			return tUser;
		} else {
			return null;
		}

	}

	/**
	 * 修改密码
	 */
	public String changePwd(TUser tuser, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		if (!tuser.getPwd().equals(oldPwd)) {
			return "error";
		}

		tuser.setPwd(newPwd);
		userDAO.getSession().clear();
		userDAO.update(tuser);

		return "success";
	}

	/**
	 * 查找用户
	 */
	public List<TUser> queryByPage(TUser tuser, int currentrecord, int pagesize) {
		// TODO Auto-generated method stub
		Criteria criteria = userDAO.getCriteria();

		criteria.setFirstResult(currentrecord);
		criteria.setMaxResults(pagesize);

		if (tuser.getUsername() != null
				&& "".equals(tuser.getUsername()) == false) {
			criteria.add(Restrictions.like("username", tuser.getUsername(),
					MatchMode.ANYWHERE));
		}
		if (tuser.getRealname() != null
				&& "".equals(tuser.getRealname()) == false) {
			criteria.add(Restrictions.like("realname", tuser.getRealname(),
					MatchMode.ANYWHERE));
		}
		if (tuser.getCollege() != null
				&& "".equals(tuser.getCollege()) == false) {
			criteria.add(Restrictions.like("college", tuser.getCollege(),
					MatchMode.ANYWHERE));
		}
		if (tuser.getRoleId() != null && "".equals(tuser.getRoleId()) == false) {
			criteria.add(Restrictions.like("roleId", tuser.getRoleId(),
					MatchMode.EXACT));
		}

		List<TUser> listTUser = (List<TUser>) userDAO.findByCriteria(criteria);

		return listTUser;
	}

	/**
	 * 删除用户
	 */
	public String delete(int id) {
		// TODO Auto-generated method stub
		try {
			userDAO.delete(userDAO.findById(id));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 修改用户
	 */
	public String update(TUser tuser) {
		// TODO Auto-generated method stub
		try {
			userDAO.getSession().clear();
			userDAO.update(tuser);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public TUser findTUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	public static String getNameById(String id) {
		TRoleDAO tRoleDAO = new TRoleDAO();
		try {
			String name = tRoleDAO.findById(id).getRoleName();
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String save(TUser tuser) {
		// TODO Auto-generated method stub
		try {
			userDAO.getSession().clear();
			userDAO.save(tuser);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public int getCount(TUser tuser) {
		// TODO Auto-generated method stub
		List<TUser> listTUser = new ArrayList<TUser>();
		listTUser = queryByPage(tuser, 0, Integer.MAX_VALUE);

		return listTUser.size();
	}

	public boolean isExist(String username) {
		// TODO Auto-generated method stub
		List<TUser> listTUser = (List<TUser>) userDAO.findByUsername(username);
		if (listTUser != null&&listTUser.size()>0) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public static String getRealnameById(Integer id){
		TUserDAO userDAO = new TUserDAO();
		String realname = null;
		
		TUser user = userDAO.findById(id);
		
		if(user!=null){
			realname = user.getRealname();
		}
		return realname;
	}
	
	public static String getUsernameById(Integer id){
		TUserDAO userDAO = new TUserDAO();
		String username = null;
		
		TUser user = userDAO.findById(id);
		
		if(user!=null){
			username = user.getUsername();
		}
		return username;
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
