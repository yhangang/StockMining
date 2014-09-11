package org.a805.service.impl.corpgovern;

import java.util.List;

import org.a805.service.corpgovern.IndexSelectService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TCompanyDAO;
import com.hibernate.dao.TIndexDAO;
import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;

public class IndexSelectServiceImpl implements IndexSelectService{
	private TIndexDAO indexDAO;
	
	

	public TIndexDAO getIndexDAO() {
		return indexDAO;
	}

	public void setIndexDAO(TIndexDAO indexDAO) {
		this.indexDAO = indexDAO;
	}



	public List<TIndex> queryIndex(TIndex index) {
		// TODO Auto-generated method stub
		Criteria criteria = indexDAO.getCriteria();
		
		if (index.getIndexType() != null
				&& "".equals(index.getIndexType()) == false) {
			criteria.add(Restrictions.like("indexType", index.getIndexType(),
					MatchMode.ANYWHERE));
		}
		
		List<TIndex> listTIndex = (List<TIndex>) indexDAO
		.findByCriteria(criteria);

		return listTIndex;
	}

	public TIndex findIndexById(String indexId) {
		// TODO Auto-generated method stub
		TIndex index = indexDAO.findById(indexId);
		return index;
	}

}
