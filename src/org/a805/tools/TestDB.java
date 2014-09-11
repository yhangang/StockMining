package org.a805.tools;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TUserDAO;
import com.hibernate.entity.TUser;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TUser t = new TUser();
/*		t.setId(new TUserId(1,"qqq"));
		t.setPwd("123");
		t.setRealname("shax");
		t.setCollege("hah");
		t.setRoleId("000003");*/
		
		
		TUserDAO dao = new TUserDAO();
		List<TUser> list = new ArrayList();
		
		

		
		Criteria criteria = dao.getCriteria();
		criteria.add(Restrictions.isNotNull("phoneNumber"));
		list = dao.findByCriteria(criteria);
		
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getRealname());
		}
		

	}

}
