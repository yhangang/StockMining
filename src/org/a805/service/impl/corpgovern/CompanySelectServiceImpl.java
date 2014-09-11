package org.a805.service.impl.corpgovern;

import java.util.List;

import org.a805.service.corpgovern.CompanySelectService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TCompanyDAO;
import com.hibernate.dao.TIndexDAO;
import com.hibernate.entity.TCompany;
import com.hibernate.entity.TIndex;

public class CompanySelectServiceImpl implements CompanySelectService{
	private TCompanyDAO companyDAO;
	
	
	public TCompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(TCompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}



	public List<TCompany> queryCompany(TCompany company) {
		// TODO Auto-generated method stub
		Criteria criteria = companyDAO.getCriteria();
		
		if (company.getClassificationOfCsrc() != null
				&& "".equals(company.getClassificationOfCsrc()) == false) {
			criteria.add(Restrictions.like("classificationOfCsrc", company.getClassificationOfCsrc(),
					MatchMode.ANYWHERE));
		}
		if (company.getClassificationOfGics() != null
				&& "".equals(company.getClassificationOfGics()) == false) {
			criteria.add(Restrictions.like("classificationOfGics", company.getClassificationOfGics(),
					MatchMode.ANYWHERE));
		}
		if (company.getArea() != null
				&& "".equals(company.getArea()) == false) {
			criteria.add(Restrictions.like("area", company.getArea(),
					MatchMode.ANYWHERE));
		}
		
		List<TCompany> listTCompany = (List<TCompany>) companyDAO
		.findByCriteria(criteria);

		return listTCompany;	
	}


	public TCompany findCompanyById(String stockId) {
		// TODO Auto-generated method stub
		TCompany company = companyDAO.findById(stockId);
		return company;
	}



}
