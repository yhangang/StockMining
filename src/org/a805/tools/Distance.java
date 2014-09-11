package org.a805.tools;

public class Distance {
	private int index1;
	private int index2;
	private int value;

	public Distance() {
	}
	/**
	 * 用于存放两个类之间距离的数据结构
	 * @param index1
	 * @param index2
	 * @param value
	 */
	public Distance(int index1, int index2, int value) {
		this.index1 = index1;
		this.index2 = index2;
		this.value = value;
	}

	public int getIndex1() {
		return index1;
	}

	public void setIndex1(int index1) {
		this.index1 = index1;
	}

	public int getIndex2() {
		return index2;
	}

	public void setIndex2(int index2) {
		this.index2 = index2;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
