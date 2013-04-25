package com.taven.algorithm;

/**
 * 插入排序
 * 
 * 方法：将一个记录插入到已排好序的有序表（有可能是空表）中,从而得到一个新的记录数增1的有序表。
 * 
 * 比较次数是前两者的一般，而复制所需的CPU时间较交换少，所以性能上比冒泡排序提高一倍多，而比选择排序也要快。
 * 
 * @author Taven.Li
 * 
 */
public class InsertSort {

	public static void main(String[] args) {

		System.out.println("------------start---------");

		int[] iArrary = new int[] { 1, 5, 13, 6, 10, 55, 99, 2, 87, 12, 34, 75,
				33, 47 };

		// 插入排序
		insertSort(iArrary);

		for (int i = 0; i < iArrary.length; ++i) {

			System.out.println("Index: " + i + " Value: " + iArrary[i]);

		}

	}

	public static void insertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			// 保证前i+1个数排好序
			for (int j = 0; j < i; j++) {

				if (arr[j] > arr[i]) {

					// 交换在位置j和i两个数
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

				}

			}

		}

	}
}
