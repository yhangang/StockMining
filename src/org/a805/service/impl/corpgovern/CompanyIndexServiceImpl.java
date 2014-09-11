package org.a805.service.impl.corpgovern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

import org.a805.service.corpgovern.CompanyIndexService;
import org.a805.tools.DateFormatTransfer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hibernate.dao.TCompanyDAO;
import com.hibernate.dao.TCompanyIndexDAO;
import com.hibernate.dao.TIndexDAO;
import com.hibernate.entity.TCompanyIndex;
import com.hibernate.entity.TCompanyIndexId;

public class CompanyIndexServiceImpl implements CompanyIndexService {
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

	public void companyIndexDataDisplay(HttpServletResponse response,
			String[] years, TreeSet<String> selectedStockId,
			TreeSet<String> selectedIndexId) {
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
					// 设置查询每个值的条件
					TCompanyIndexId tCompanyIndexId = new TCompanyIndexId();
					tCompanyIndexId.setIndexDate("2004-00-00");
					tCompanyIndexId.setStockId(stockId);
					tCompanyIndexId.setIndexId(indexId);
					double indexValue = 0;
					if (companyIndexDAO.findById(tCompanyIndexId) != null) {
						indexValue = companyIndexDAO.findById(tCompanyIndexId)
								.getIndexValue();
					}

					cellHSS = rowHSS.createCell(column++);
					cellHSS.setEncoding(HSSFCell.ENCODING_UTF_16);
					cellHSS.setCellValue(indexValue);
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

}
