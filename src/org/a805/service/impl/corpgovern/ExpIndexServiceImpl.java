package org.a805.service.impl.corpgovern;

import java.util.List;
import java.util.TreeSet;

import org.a805.service.corpgovern.ExpIndexService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TExpCompanyDAO;
import com.hibernate.dao.TExpIndexDAO;
import com.hibernate.entity.TExpCompany;
import com.hibernate.entity.TExpIndex;
import com.hibernate.entity.TExpIndexId;

public class ExpIndexServiceImpl implements ExpIndexService {
	private TExpIndexDAO expIndexDAO;

	
	public TExpIndexDAO getExpIndexDAO() {
		return expIndexDAO;
	}

	public void setExpIndexDAO(TExpIndexDAO expIndexDAO) {
		this.expIndexDAO = expIndexDAO;
	}

	public String delete(int expId) {
		// TODO Auto-generated method stub
		TExpIndexDAO expIndexDAO = new TExpIndexDAO();
		Criteria criteria = expIndexDAO.getCriteria();

		criteria.add(Restrictions.eq("id.expId", expId));
		
		//先找出符合条件的记录，在遍历逐个删除
		List<TExpIndex> listTExpTExpIndex = (List<TExpIndex>) expIndexDAO
		.findByCriteria(criteria);
		
		for(TExpIndex entity:listTExpTExpIndex){
			expIndexDAO.delete(entity);
		}
		
		
		return "success";
	}

	public String save(int expId, TreeSet<String> selectedIndexId) {
		// TODO Auto-generated method stub
		//先删除之前的记录
		delete(expId);
		
		TExpIndexDAO expIndexDAO = new TExpIndexDAO();
		for (String indexId : selectedIndexId) {
			TExpIndex entity = new TExpIndex();
			TExpIndexId id = new TExpIndexId();
			id.setExpId(expId);
			id.setIndexId(indexId);
			entity.setId(id);
			entity.setGuiyueDepth(1);
			entity.setWeighDepth(1);
			
			expIndexDAO.save(entity);
		}

		return "success";
	}
	
	public TreeSet<String> getSelectedSIndexId(int expId) {
		// TODO Auto-generated method stub
		TExpIndexDAO expIndexDAO = new TExpIndexDAO();
		Criteria criteria = expIndexDAO.getCriteria();
		
		criteria.add(Restrictions.eq("id.expId", expId));
		//找出符合条件的记录
		List<TExpIndex> listTExpIndex = (List<TExpIndex>) expIndexDAO
		.findByCriteria(criteria);
		
		TreeSet<String> set = new TreeSet<String>();
		
		for(TExpIndex entity:listTExpIndex){
			set.add(entity.getId().getIndexId());
			
		}	
		return set;
	}
	
	public static void main(String a[]){
		ExpIndexServiceImpl test = new ExpIndexServiceImpl();
		TreeSet<String> selectedIndexId = new TreeSet<String>();
		selectedIndexId.add("000001");
		selectedIndexId.add("000002");
		selectedIndexId.add("000003");
		//test.save(1, selectedIndexId);
		test.delete(1);
		
		
	}



}
