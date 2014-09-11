package org.a805.service.impl.corpgovern;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.hibernate.dao.TCompanyDAO;

public class CountST {

	public int countST(Map<String, String> map) {
		// 初始化ST公司个数
		TCompanyDAO dao = new TCompanyDAO();
		int count = 0;

		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String stockName = "";
			try {
				stockName = dao.findById(entry.getKey()).getStockShortName();
			} catch (Exception e) {
				stockName = "";
			}
			if (stockName.contains("ST")) {
				count++;
			}
		}

		return count;
	}

	public static void main(String a[]) {
		CountST test = new CountST();
		Map<String, String> map = new TreeMap<String, String>();
		map.put("000005a", "000025");
		map.put("2", "哈ST哈");
		System.out.println(test.countST(map));

	}

}
