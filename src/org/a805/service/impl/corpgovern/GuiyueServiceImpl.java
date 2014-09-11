package org.a805.service.impl.corpgovern;

import org.a805.service.corpgovern.GetIndustryAvgService;
import org.a805.service.corpgovern.GuiyueService;

import com.hibernate.dao.TCompanyIndexDAO;
import com.hibernate.entity.TCompanyIndexId;

public class GuiyueServiceImpl implements GuiyueService {
	private TCompanyIndexDAO companyIndexDAO;
	private GetIndustryAvgService industryAvgService;

	public TCompanyIndexDAO getCompanyIndexDAO() {
		return companyIndexDAO;
	}

	public void setCompanyIndexDAO(TCompanyIndexDAO companyIndexDAO) {
		this.companyIndexDAO = companyIndexDAO;
	}


	public GetIndustryAvgService getIndustryAvgService() {
		return industryAvgService;
	}

	public void setIndustryAvgService(GetIndustryAvgService industryAvgService) {
		this.industryAvgService = industryAvgService;
	}

	/**
	 * 按平均值规约
	 */
	public String GuiyueByAverage(String stockId, String indexId,
			String indexDate, int weight) {
		// TODO Auto-generated method stub
		int geneLenth = 1;
		
		TCompanyIndexDAO companyIndexDAO = new TCompanyIndexDAO();
		industryAvgService = new GetIndustryAvgServiceImpl();

		// 该指标的基因片段
		String geneSegment = "";
		// 指标值
		double indexValue = 0.0;
		// 指标平均值
		double indexAverageValue;

		// 第一步 获取指标值和规约标准--平均值
		// 设置查询每个值的条件
		TCompanyIndexId tCompanyIndexId = new TCompanyIndexId();
		tCompanyIndexId.setIndexDate("2004-00-00");
		tCompanyIndexId.setStockId(stockId);
		tCompanyIndexId.setIndexId(indexId);
		// 获取指标值
		if (companyIndexDAO.findById(tCompanyIndexId) != null) {
			indexValue = companyIndexDAO.findById(tCompanyIndexId)
					.getIndexValue();
		}
		else{
			//该指标没有值返回0  暂时这么写
			indexValue = 0.0;
		}
		// 获取平均值
		indexAverageValue = 0.0;
		indexAverageValue = industryAvgService.getIndustryAvg(stockId, indexId, indexDate);


		

		// 第二步 比较指标值和平均值，规约得出基本时段基因
		String tempGene = null;
		if (indexValue >= indexAverageValue)
			tempGene = "1";
		else
			tempGene = "0";

		// 第三步 由权重得出该指标最终时段基因
		for (int i = 0; i < weight; i++) {
			geneSegment += tempGene;
		}
		// 不满16位，左侧补0
		while (geneSegment.length() < geneLenth) {
			geneSegment = "0" + geneSegment;
		}
		

		return geneSegment;
	}

	public static void main(String a[]) {
		GuiyueServiceImpl test = new GuiyueServiceImpl();
		String geneSegment = null;
		geneSegment = test.GuiyueByAverage("000002", "000005", "2004-00-00", 2);
		System.out.println(geneSegment);

	}


}
