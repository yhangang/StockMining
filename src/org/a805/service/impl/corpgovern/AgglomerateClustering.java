package org.a805.service.impl.corpgovern;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AgglomerateClustering {
	private int[] entity;

	/**
	 * 初始化函数，将每个实体单独分为一类
	 * 
	 * @param totalEntities
	 */
	public void init(int totalEntities) {
		// 数组下标从1开始，舍弃0，以便更形象的标识类别
		entity = new int[totalEntities + 1];
		// 每个实体初始化，单独分为一类
		for (int i = 1; i <= totalEntities; i++) {
			entity[i] = i;
		}
	}

	/**
	 * 聚类函数，将指定的两个类合并为一类
	 * 
	 * @param index1
	 * @param index2
	 */
	public boolean merge(int index1, int index2) {
		Set<Integer> categories = this.getCategory();
		// 如果类别中没有参数中的类号，返回错误，合并失败
		if (!categories.contains(Integer.valueOf(index1))
				|| !categories.contains(Integer.valueOf(index2))) {
			return false;
		}
		//合并的类号如果相同，直接返回成功
		if (index1 == index2) {
			return true;
		}

		// 获得合并的两类中，较小的那个类号继续使用，较大的舍弃，程序使得index1始终较小
		if (index1 > index2) {
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}
		// 将所有类号是index2的换成index1，表示这两个归为一类，类号使用较小的index1
		for (int i = 1; i <= entity.length - 1; i++) {
			if (entity[i] == index2) {
				entity[i] = index1;
			}
		}
		return true;

	}

	/**
	 * 得到目前的类别
	 * 
	 * @return
	 */
	public Set<Integer> getCategory() {
		Set<Integer> categories = new TreeSet<Integer>();
		for (int i = 1; i <= entity.length - 1; i++) {
			categories.add(Integer.valueOf(entity[i]));
		}
		return categories;

	}

	/**
	 * 得到目前的类别数
	 * 
	 * @return
	 */
	public int getCategoryNumbers() {
		Set<Integer> categories = new TreeSet<Integer>();
		for (int i = 1; i <= entity.length - 1; i++) {
			categories.add(Integer.valueOf(entity[i]));
		}
		return categories.size();

	}

	/**
	 * 得到聚类用的数据结构
	 * 
	 * @return
	 */
	public int[] getEntities() {
		return entity;
	}

	/**
	 * 返回聚类结果
	 * 
	 * @return
	 */
	public Map<String, Set<Integer>> getResult() {
		// 得到类别
		Set<Integer> categories = getCategory();
		// 携带结果的Map
		Map<String, Set<Integer>> result = new TreeMap<String, Set<Integer>>();
		// 对每个类别新建一个匿名对象TreeSet
		for (Integer i : categories) {
			result.put(String.valueOf(i), new TreeSet<Integer>());
		}
		// 遍历entity，将每个元素归到对应的类里，也就是Set
		for (int i = 1; i <= entity.length - 1; i++) {
			Set<Integer> tempSet = result.get(String.valueOf(entity[i]));
			tempSet.add(Integer.valueOf(i));
			result.put(String.valueOf(entity[i]), tempSet);
		}

		return result;
	}

	// 测试用的主函数
	public static void main(String a[]) {
		AgglomerateClustering test = new AgglomerateClustering();
		test.init(100);
		test.merge(2, 5);
		test.merge(3, 6);
		for (int i = 10; i < 50; i++) {
			test.merge(2, i);
		}

		// 打印聚类结果
		Map<String, Set<Integer>> result = test.getResult();
		Iterator it = result.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Set<Integer>> map = (Map.Entry<String, Set<Integer>>) it
					.next();
			System.out.print(map.getKey() + "     ");

			Set<Integer> set = map.getValue();
			for (Integer i : set) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
