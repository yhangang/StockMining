package org.a805.service.impl.corpgovern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

import org.a805.service.corpgovern.ShowGuiyueResultService;
import org.a805.tools.DateFormatTransfer;
import org.a805.tools.NumberFormatTransfer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hibernate.dao.TCompanyDAO;
import com.hibernate.dao.TCompanyIndexDAO;
import com.hibernate.dao.TIndexDAO;
import com.hibernate.entity.TCompanyIndex;
import com.hibernate.entity.TCompanyIndexId;

public class ShowGuiyueResultServiceImpl implements ShowGuiyueResultService {
	private TCompanyIndexDAO companyIndexDAO;
	private TCompanyDAO companyDAO;
	private TIndexDAO indexDAO;

	public TCompanyIndexDAO getCompanyIndexDAO() {
		return companyIndexDAO;
	}

	public void setCompanyIndexDAO(TCompanyIndexDAO companyIndexDAO) {
		this.companyIndexDAO = companyIndexDAO;
	}

	public TCompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(TCompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public TIndexDAO getIndexDAO() {
		return indexDAO;
	}

	public void setIndexDAO(TIndexDAO indexDAO) {
		this.indexDAO = indexDAO;
	}

	public TCompanyIndex findById(TCompanyIndexId id) {
		// TODO Auto-generated method stub
		return companyIndexDAO.findById(id);
	}

	/**
	 * 以excel表格形式返回规约结果
	 */
	public void showGuiyueResult(HttpServletResponse response,
			String[] selectedYears, TreeSet<String> selectedStockId,
			TreeSet<String> selectedIndexId, String numberFormat, int weight) {
		// TODO Auto-generated method stub

		try {
			// 创建EXCEL工作本
			HSSFWorkbook wb = new HSSFWorkbook();

			String year = "2004";

			short row = 0, column = 0;

			// 创建一个EXCEL页
			HSSFSheet sheet = wb.createSheet(year);
			// 创建一个EXCEL行 第一行表头
			HSSFRow rowHSS = sheet.createRow(row++);

			// 创建单元格
			HSSFCell cellHSS = rowHSS.createCell(column++);
			cellHSS.setEncoding(HSSFCell.ENCODING_UTF_16);
			// 设置单元格内容
			cellHSS.setCellValue("");

			for (String indexId : selectedIndexId) {
				// 第一行，所有的指标名称
				cellHSS = rowHSS.createCell(column++);
				cellHSS.setEncoding(HSSFCell.ENCODING_UTF_16);
				cellHSS.setCellValue(indexDAO.findById(indexId).getIndexName()
						.toString());
			}

			// 从第二行开始写内容，上面是表头
			for (String stockId : selectedStockId) {
				// 每行的第一列，公司名称
				rowHSS = sheet.createRow(row++);
				column = 0;
				cellHSS = rowHSS.createCell(column++);
				cellHSS.setEncoding(HSSFCell.ENCODING_UTF_16);
				cellHSS.setCellValue(companyDAO.findById(stockId)
						.getStockShortName().toString());

				for (String indexId : selectedIndexId) {
					// 调用用于规约的函数
					String geneSegment = "";
					geneSegment = (new GuiyueServiceImpl()).GuiyueByAverage(
							stockId, indexId, "2004-00-00", weight);

					// 判断使用二进制还是十六进制
					if ("hexadecimal".equals(numberFormat)) {
						geneSegment = NumberFormatTransfer
								.gene2gene16(geneSegment);

					}

					cellHSS = rowHSS.createCell(column++);
					cellHSS.setEncoding(HSSFCell.ENCODING_UTF_16);
					cellHSS.setCellValue(geneSegment);
				}

			}

			// 设置为下载
			response.setContentType("application/x-download");
			// 设置下载的文件名,设置头信息
			String title1 = "attachment;filename=";
			String title2 = DateFormatTransfer.dateToString(new Date(),
					"yyyyMMddHHmmss").concat(".xls");
			String title = title1.concat(title2);
			response.addHeader("Content-Disposition", title);
			// 创建一个输出流，输出到内存
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				wb.write(os);
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] content = os.toByteArray();
			// 创建一个输入流，读取内存
			InputStream is1 = new ByteArrayInputStream(content);
			// 获得输出流对象，进行读写操作
			OutputStream out = response.getOutputStream();
			byte[] dd = new byte[1024];
			while (is1.read(dd) != -1) {
				out.write(dd);
			}
			// 关闭流
			out.flush();
			if (out != null) {
				out.close();
			}
			if (is1 != null) {
				is1.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 返回Map格式的规约结果，作为聚类方法的参数，数据源
	 */
	public Map<String, String> getGenomes(ArrayList<String> selectedYears,
			TreeSet<String> selectedStockId, TreeSet<String> selectedIndexId,
			String numberFormat, int weight) {
		// TODO Auto-generated method stub
		Map<String, String> genomesMap = new TreeMap<String, String>();

		// 将一年每个公司的的所有指标组合成字符长串，叫做基因 组成 基因组
		for (String stockId : selectedStockId) {
			//每个公司的串，包含所有指标
			String genome = "";

			for (String indexId : selectedIndexId) {
				// 调用用于规约的函数
				//每个指标的串，包含所有年份
				String gene = "";
			
				for(String year : selectedYears){
					//每个指标每个年份的串
					String ge = "";
					ge = (new GuiyueServiceImpl()).GuiyueByAverage(stockId,
							indexId, year, weight);
					// 判断使用二进制还是十六进制
					if ("hexadecimal".equals(numberFormat)) {
						ge = NumberFormatTransfer.gene2gene16(ge);
					}
					gene = gene + ge;
				}
				//拼串ing
				genome = genome + gene;
			}
			//拼完一个完整的串，存入Map，key为公司的编码，value为该串
			genomesMap.put(stockId, genome);

		}
		System.out.println("公司数："+selectedStockId.size());
		System.out.println("指标数："+selectedIndexId.size());
		System.out.println("年份数："+selectedYears.size());

		return genomesMap;
	}

}
