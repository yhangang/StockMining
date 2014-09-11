package org.a805.tools;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TSysglobalDAO;
import com.hibernate.entity.TSysglobal;
import com.hibernate.entity.TSysglobalId;

public class SysglobalQuery {

	/* 根据 name 查找 key 和 value */
	public static Map<String, String> queryKeyAndValue(String name) {
		TSysglobalDAO dao = new TSysglobalDAO();
		Criteria criteria = dao.getCriteria();

		criteria.add(Restrictions.like("id.paramName", name, MatchMode.EXACT));

		List<TSysglobal> list = (List<TSysglobal>) dao.findByCriteria(criteria);

		Map<String, String> map = new TreeMap<String, String>();

		for (TSysglobal ts : list) {
			map.put(ts.getId().getParamKey(), ts.getId().getParamVal());
		}
		return map;
	}

	/* 根据 name 和 key 查找 value */
	public static String queryValue(String name, String key) {
		TSysglobalDAO dao = new TSysglobalDAO();
		Criteria criteria = dao.getCriteria();

		criteria.add(Restrictions.like("id.paramName", name, MatchMode.EXACT));
		criteria.add(Restrictions.like("id.paramKey", key, MatchMode.EXACT));

		String value = null;
		List<TSysglobal> list = (List<TSysglobal>) dao.findByCriteria(criteria);
		try {
			value = list.get(0).getId().getParamVal();
		} catch (Exception e) {
			value = null;
		}

		return value;
	}

	/* 根据 name 和 value 查找 key */
	
	  public static String queryKey(String name,String value){
		  TSysglobalDAO dao = new TSysglobalDAO();
		Criteria criteria = dao.getCriteria();

		criteria.add(Restrictions.like("id.paramName", name, MatchMode.EXACT));
		criteria.add(Restrictions.like("id.paramVal", value, MatchMode.EXACT));

		String key = null;
		List<TSysglobal> list = (List<TSysglobal>) dao.findByCriteria(criteria);
		try {
			key = list.get(0).getId().getParamKey();
		} catch (Exception e) {
			key = null;
		}

		return key;
	  }
	 
	public static void main(String a[]) {

		String s = SysglobalQuery.queryKey("ExpPower", "公开可见");
		System.out.println(s);

	}
}
