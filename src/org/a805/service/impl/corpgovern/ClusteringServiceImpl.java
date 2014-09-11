package org.a805.service.impl.corpgovern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.a805.service.corpgovern.ClusteringService;
import org.a805.tools.Distance;

public class ClusteringServiceImpl implements ClusteringService {
	public static final int ERROR = -1;

	/**
	 * 测距函数，用于测算两个不同基因组之间的距离
	 */
	public int calculateDIstance(String genome1, String genome2) {
		// TODO Auto-generated method stub
		// 不符合条件的参数，返回错误
		if (genome1 == null || genome2 == null)
			return ERROR;
		// 两个基因组长度不匹配，返回错误
		if (genome1.length() != genome2.length())
			return ERROR;

		// 测距开始

		// 基因组的复制，用于操作
		String temp1 = genome1;
		String temp2 = genome2;
		// 本次比较的一位字符
		String operator1 = "";
		String operator2 = "";
		// 存放距离的变量
		int count = 0;

		while (temp1.length() != 0) {
			// 取每个基因组的第一位字符
			operator1 = temp1.substring(0, 1);
			operator2 = temp2.substring(0, 1);
			// 将被取的字符剔除
			temp1 = temp1.substring(1);
			temp2 = temp2.substring(1);
			// 比较距离
			if (!operator1.equals(operator2)) {
				count++;
			}
		}

		return count;
	}

	/**
	 * 聚类实现函数
	 */
	public Map<String, Map<String, String>> ClusteringOfAgglomerate(
			Map<String, String> map, int classes) {
		// TODO Auto-generated method stub
		// 构造公司id、时段基因与类号的1 2 3……的关联，通过Map实现
		Map<String, String> mapOfStockId = new TreeMap<String, String>();
		Map<String, String> mapOfGenome = new TreeMap<String, String>();

		// 初始化1、2、3……与公司id、时段基因的关联
		Iterator<Map.Entry<String, String>> it1 = map.entrySet().iterator();
		for (int i = 1; it1.hasNext(); i++) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it1
					.next();
			mapOfStockId.put(String.valueOf(i), entry.getKey());
			mapOfGenome.put(String.valueOf(i), entry.getValue());
		}

		// 下面构造距离矩阵和链表

		// 矩阵的维数，也即被选公司的个数
		int mapSize = map.size();
		int[][] distanceMatrix = new int[mapSize + 1][mapSize + 1];
		List<Distance> distanceList = new ArrayList<Distance>();

		for (int i = 1; i <= mapSize; i++) {
			for (int j = 1; j <= mapSize; j++) {
				if (i <= j)
					continue;
				String genome1 = mapOfGenome.get(String.valueOf(i));
				String genome2 = mapOfGenome.get(String.valueOf(j));
				int distance = calculateDIstance(genome1, genome2);
				// 矩阵的形式存放
				distanceMatrix[i][j] = distance;
				// 顺序表的形式存放
				distanceList.add(new Distance(i, j, distance));

			}
		}
		//对顺序表按距离的值进行排序
		
		//使用java自带的Comparator接口进行排序
		 Comparator<Distance> comparator = new Comparator<Distance>(){
			 public int compare(Distance distance1,Distance distance2){
				 if(distance1.getValue()<distance2.getValue()){
					 return -1;
				 }
				return 1;
			 }
		 };
		
		 Collections.sort(distanceList, comparator);
		
		

		// 开始按顺序聚类
		AgglomerateClustering clustering = new AgglomerateClustering();
		clustering.init(mapSize);

		// 聚类的具体过程

		for (Distance instance : distanceList) {
			if (clustering.getCategoryNumbers() <= classes) {
				break;
			}
			clustering.merge(instance.getIndex1(), instance.getIndex2());

		}

		/*
		 * 效率很低的聚类算法
		 * 
		 * int index1 = 1, index2 = 1; int minimum = Integer.MAX_VALUE; while
		 * (clustering.getCategoryNumbers() > classes) { minimum =
		 * Integer.MAX_VALUE;
		 * 
		 * for (int i = 1; i <= mapSize; i++) { for (int j = 1; j <= mapSize;
		 * j++) { if (i <= j) continue; if (distanceMatrix[i][j] < minimum) {
		 * minimum = distanceMatrix[i][j]; index1 = i; index2 = j;
		 * distanceMatrix[i][j] = Integer.MAX_VALUE; } } }
		 * clustering.merge(index1, index2); }
		 */

		// 转换结果的数据格式
		// 接受聚类的结果
		Map<String, Set<Integer>> resultOfAbstract = clustering.getResult();
		// 聚类结果的最终格式
		Map<String, Map<String, String>> finalResult = new TreeMap<String, Map<String, String>>();

		Iterator<Map.Entry<String, Set<Integer>>> it2 = resultOfAbstract
				.entrySet().iterator();
		for (int i = 1; it2.hasNext(); i++) {
			Map.Entry<String, Set<Integer>> entry = (Map.Entry<String, Set<Integer>>) it2
					.next();

			Set<Integer> set = entry.getValue();
			Map<String, String> mapOfClass = new TreeMap<String, String>();

			// 将SET中的聚类结果一一转换为公司id和对应的时段基因
			for (Integer j : set) {
				mapOfClass.put(mapOfStockId.get(String.valueOf(j)), mapOfGenome
						.get(String.valueOf(j)));
			}

			finalResult.put(String.valueOf(i), mapOfClass);

		}

		// 控制台打印
		/*
		 * for (int i = 1; i <= mapSize; i++) { for (int j = 1; j <= mapSize;
		 * j++) { if (i < j) continue; System.out.print(distanceMatrix[i][j] + "
		 * "); } System.out.println(); }
		 */

		return finalResult;
	}

	public static void main(String a[]) {
		ClusteringServiceImpl test = new ClusteringServiceImpl();
		System.out.println(test.calculateDIstance("1", "2"));

	}

}
