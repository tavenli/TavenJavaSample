package com.taven.algorithm;

/**
 * 快速排序
 * 
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）
 * 
 * 步骤为： 1. 从数列中挑出一个元素，称为 "基准"（pivot） 2.
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作 3.
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序
 * 递回的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递回下去，但是这个算法总会结束，
 * 因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去
 * 
 * @author Taven.Li
 * 
 */
public class QuickSort {

	public static void main(String[] args) {

		System.out.println("------------start---------");

		int[] iArrary = new int[] { 1, 2, 44, 32, 8 };

		// 快速排序
		quickSort(iArrary);

		for (int i = 0; i < iArrary.length; ++i) {

			System.out.println("Index: " + i + " Value: " + iArrary[i]);

		}

	}
	
	/**
	 * 实现思路1
	 * 
	 * @param numbers
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	}  

	/**
	 * 实现思路2
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		
		sort(arr, 0, arr.length-1);

	}

	private static void sort(int[] arr, int low, int hight) {

		if (low < hight) {

			int result = partition(arr, low, hight);

			sort(arr, low, result - 1);

			sort(arr, result + 1, hight);

		}

	}
	
	private static int partition(int[] arr, int low, int hight) {

		int key = arr[low];

		while (low < hight) {

			while (low < hight && arr[hight] >= key){

				hight--;
			}
			arr[low] = arr[hight];

			while (low < hight && arr[low] <= key){
				low++;
			}
			arr[hight] = arr[low];

		}

		arr[low] = key;

		return low;

	}



}
