package com.taven.algorithm;

/**
 * 
 * 
 * @author Taven.Li
 *
 */
public class Reverse {

	public static void main(String[] args) {

		System.out.println("------------start---------");

		int[] iArrary = new int[] { 1, 2, 3, 4, 5 };

		// 反转
		reverse(iArrary);

		for (int i = 0; i < iArrary.length; ++i) {

			System.out.println("Index: " + i + " Value: " + iArrary[i]);

		}

	}

	public static void reverse(int[] arr) {
		
		  int length = arr.length;   

          int temp = 0;//临时变量 

          for (int i = 0; i < length / 2; i++) {   

                 temp = arr[i];
                 arr[i] = arr[length - 1 - i];
                 arr[length - 1 - i] = temp;   

          }   
          
	}
}
