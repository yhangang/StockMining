package org.a805.service.impl.corpgovern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.a805.service.corpgovern.ExperimentInformationService;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.TExperimentInformationDAO;
import com.hibernate.entity.TExperimentInformation;
import com.hibernate.entity.TLoginLog;

public class ExperimentInformationServiceImpl implements
		ExperimentInformationService {
	private TExperimentInformationDAO experimentInformationDAO;

	public TExperimentInformationDAO getExperimentInformationDAO() {
		return experimentInformationDAO;
	}

	public void setExperimentInformationDAO(
			TExperimentInformationDAO experimentInformationDAO) {
		this.experimentInformationDAO = experimentInformationDAO;
	}

	public List<TExperimentInformation> queryByPage(
			TExperimentInformation experimentInformation, int currentrecord,
			int pagesize) {
		// TODO Auto-generated method stub
		Criteria criteria = experimentInformationDAO.getCriteria();

		criteria.setFirstResult(currentrecord);
		criteria.setMaxResults(pagesize);

		
		if (experimentInformation.getExpName() != null
				&& "".equals(experimentInformation.getExpName()) == false) {
			criteria.add(Restrictions.like("expName", experimentInformation.getExpName(),
					MatchMode.ANYWHERE));
		}
		
		if (experimentInformation.getUserId() != null) {
			criteria.add(Restrictions.eq("userId", experimentInformation.getUserId()));
		}
		

		List<TExperimentInformation> listTExperimentInformation = (List<TExperimentInformation>) experimentInformationDAO
				.findByCriteria(criteria);

		return listTExperimentInformation;

	}

	public int getCount(TExperimentInformation experimentInformation) {
		// TODO Auto-generated method stub
		List<TExperimentInformation> listTExperimentInformation = new ArrayList<TExperimentInformation>();
		listTExperimentInformation = queryByPage(experimentInformation, 0,
				Integer.MAX_VALUE);
		return listTExperimentInformation.size();
	}

	public List<TExperimentInformation> queryByPage(int currentrecord,
			int pagesize) {
		// TODO Auto-generated method stub
		Criteria criteria = experimentInformationDAO.getCriteria();

		criteria.setFirstResult(currentrecord);
		criteria.setMaxResults(pagesize);

		List<TExperimentInformation> listTExperimentInformation = (List<TExperimentInformation>) experimentInformationDAO
				.findByCriteria(criteria);

		return listTExperimentInformation;
	}
	
	public String updateTime(int expId,Date date) {
		// TODO Auto-generated method stub
		TExperimentInformationDAO experimentInformationDAO = new TExperimentInformationDAO();
		
		TExperimentInformation entity = experimentInformationDAO.findById(expId);
		entity.setUpdateTime(date);
		experimentInformationDAO.update(entity);
		
		return null;
	}

	public String save(TExperimentInformation experimentInformation) {
		// TODO Auto-generated method stub
		try {
			experimentInformationDAO.getSession().clear();
			experimentInformationDAO.save(experimentInformation);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}



}
