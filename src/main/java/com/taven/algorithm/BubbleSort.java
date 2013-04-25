package com.taven.algorithm;

/**
 * 冒泡排序----交换排序的一种
 * 
 * 方法：相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），下一次循环是将其他的数进行类似操作。   
 * 
 * @author Taven.Li
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		System.out.println("------------start---------");

		int[] iArrary = new int[] { 1, 5, 13, 6, 10, 55, 99, 2, 87, 12, 34, 75,
				33, 47 };

		// 冒泡排序
		BubbleSort1(iArrary);

		for (int i = 0; i < iArrary.length; ++i) {

			System.out.println("Index: " + i + " Value: " + iArrary[i]);

		}

	}

	public static void BubbleSort1(int[] arr) {

		// 外层循环每次把参与排序的最大数排在最后
		for (int i = 1; i < arr.length; i++) {

			// 内层循环负责对比相邻的两个数，并把大的排在后面
			for (int j = 0; j < arr.length - i; j++) {

				if (arr[j] > arr[j + 1]) {
					// 如果前一个大于后一个数，则交换两个数
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}

	}

	public static void BubbleSort2(int[] list) {
		int i, j, temp;

		boolean done = false;
		j = 1;
		while ((j < list.length) && (!done)) {

			done = true;

			for (i = 0; i < list.length - j; i++) {
				if (list[i] > list[i + 1]) {
					done = false;
					temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}

			j++;

		}

	}

}
