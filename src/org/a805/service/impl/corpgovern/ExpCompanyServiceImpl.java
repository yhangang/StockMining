package org.a805.service.impl.corpgovern;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.a805.service.corpgovern.ExpCompanyService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TExpCompanyDAO;
import com.hibernate.entity.TExpCompany;
import com.hibernate.entity.TExpCompanyId;

public class ExpCompanyServiceImpl implements ExpCompanyService {
	private TExpCompanyDAO expCompanyDAO;

	public TExpCompanyDAO getExpCompanyDAO() {
		return expCompanyDAO;
	}

	public void setExpCompanyDAO(TExpCompanyDAO expCompanyDAO) {
		this.expCompanyDAO = expCompanyDAO;
	}

	public String delete(int expId) {
		// TODO Auto-generated method stub
		TExpCompanyDAO expCompanyDAO = new TExpCompanyDAO();
		Criteria criteria = expCompanyDAO.getCriteria();

		criteria.add(Restrictions.eq("id.expId", expId));

		// 先找出符合条件的记录，在遍历逐个删除
		List<TExpCompany> listTExpCompany = (List<TExpCompany>) expCompanyDAO
				.findByCriteria(criteria);

		for (TExpCompany entity : listTExpCompany) {
			expCompanyDAO.delete(entity);
		}

		return "success";
	}

	public String save(int expId, TreeSet<String> selectedStockId) {
		// TODO Auto-generated method stub
		// 先删除之前的记录
		delete(expId);

		TExpCompanyDAO expCompanyDAO = new TExpCompanyDAO();
		for (String stockId : selectedStockId) {
			TExpCompany entity = new TExpCompany();
			TExpCompanyId id = new TExpCompanyId();
			id.setExpId(expId);
			id.setStockId(stockId);
			entity.setId(id);

			expCompanyDAO.save(entity);
		}

		return "success";
	}

	public TreeSet<String> getSelectedStockId(int expId) {
		// TODO Auto-generated method stub
		TExpCompanyDAO expCompanyDAO = new TExpCompanyDAO();
		Criteria criteria = expCompanyDAO.getCriteria();

		criteria.add(Restrictions.eq("id.expId", expId));
		// 找出符合条件的记录
		List<TExpCompany> listTExpCompany = (List<TExpCompany>) expCompanyDAO
				.findByCriteria(criteria);

		TreeSet<String> set = new TreeSet<String>();

		for (TExpCompany entity : listTExpCompany) {
			set.add(entity.getId().getStockId());

		}
		return set;
	}

	public String saveResults(int expId,
			Map<String, Map<String, String>> finalResult) {
		// TODO Auto-generated method stub
		TExpCompanyDAO expCompanyDAO = new TExpCompanyDAO();
		delete(expId);

		Iterator<Map.Entry<String, Map<String, String>>> it = finalResult
				.entrySet().iterator();
		int category = 1;

		while (it.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = (Map.Entry<String, Map<String, String>>) it
					.next();
			Map<String, String> map = entry.getValue();

			Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();

			System.out.println("第" + category + "类");

			while (it2.hasNext()) {
				Map.Entry<String, String> entry2 = it2.next();
				TExpCompany entity = new TExpCompany();
				TExpCompanyId id = new TExpCompanyId();
				id.setExpId(expId);
				id.setStockId(entry2.getKey());
				entity.setId(id);
				entity.setCategory(category);
				expCompanyDAO.save(entity);
				
				System.out.print("长度：" + entry2.getValue().length());
				System.out.print("  股票id：" + entry2.getKey());
				System.out.println("  时段基因：" + entry2.getValue());

			}
			category++;

		}

		return "success";
	}

	public static void main(String a[]) {
		ExpCompanyServiceImpl test = new ExpCompanyServiceImpl();
		TreeSet<String> selectedStockId = new TreeSet<String>();
		selectedStockId.add("000001");
		selectedStockId.add("000002");
		selectedStockId.add("000003");
		// test.save(1, selectedStockId);
		test.delete(1);

	}

}
