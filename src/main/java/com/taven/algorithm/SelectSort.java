package com.taven.algorithm;

/**
 * 直接选择排序法----选择排序的一种
 * 
 * 方法：每一趟从待排序的数据元素中选出最小（或最大）的一个元素， 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。 
 * 
 * 交换次数比冒泡排序少多了，由于交换所需CPU时间比比较所需的CUP时间多，所以选择排序比冒泡排序快。 
 * 但是N比较大时，比较所需的CPU时间占主要地位，所以这时的性能和冒泡排序差不太多，但毫无疑问肯定要快些。 
 * 
 * @author Taven.Li
 *
 */
public class SelectSort {

	
	public static void main(String[] args) {

		System.out.println("------------start---------");

		int[] iArrary = new int[] { 1, 5, 13, 6, 10, 55, 99, 2, 87, 12, 34, 75,
				33, 47 };

		// 选择排序
		selectSort(iArrary);

		for (int i = 0; i < iArrary.length; ++i) {

			System.out.println("Index: " + i + " Value: " + iArrary[i]);

		}

	}
	
	public static void selectSort(int[] arr) {
		
		 int index;   

         for (int i = 1; i < arr.length; i++) {
                index = 0;
                for (int j = 1; j <= arr.length - i; j++) {
                       if (arr[j] > arr[index]) {
                              index = j;
                       }
                }
                //交换在位置arr.length-i和index(最大值)两个数
                int temp = arr[index];
				arr[index] = arr[arr.length - i];
				arr[arr.length - i] = temp;
         }   

	}
	
}
