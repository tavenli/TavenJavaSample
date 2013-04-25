package com.taven.algorithm;

/**
 * 堆积排序(Heapsort)是指利用堆积树（堆）这种资料结构所设计的一种排序算法，
 * 可以利用数组的特点快速定位指定索引的元素。堆排序是不稳定的排序方法，辅助空间为O(1)， 最坏时间复杂度为O(nlog2n)
 * ，堆排序的堆序的平均性能较接近于最坏性能。
 * 
 * @author Taven.Li
 * 
 */
public class HeapSort {

	private static int[] Heap = new int[] { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 };

	public static void main(String[] args) {

		System.out.println("------------start---------");

		int i; // 循环计数变量
		int Index = Heap.length; // 数据索引变量
		System.out.print("排序前: ");
		for (i = 1; i < Index - 1; i++){
			System.out.printf("%3s", Heap[i]);
		}
		System.out.println("");
		
		heapSort(Index - 2); // 堆排序
		
		System.out.print("排序后: ");
		for (i = 1; i < Index - 1; i++){
			System.out.printf("%3s", Heap[i]);
		}
		
		System.out.println("");

		for (int j = 0; j < Heap.length; ++j) {

			System.out.println("Index: " + j + " Value: " + Heap[j]);

		}

	}

	/**
	 * 建立堆
	 */
	public static void CreateHeap(int Root, int Index) {
		int i, j; // 循环计数变量
		int Temp; // 暂存变量
		int Finish; // 判断堆是否建立完成
		j = 2 * Root; // 子节点的Index
		Temp = Heap[Root]; // 暂存Heap的Root 值
		Finish = 0; // 预设堆建立尚未完成
		while (j <= Index && Finish == 0) {
			if (j < Index) // 找最大的子节点
				if (Heap[j] < Heap[j + 1])
					j++;
			if (Temp >= Heap[j])
				Finish = 1; // 堆建立完成
			else {
				Heap[j / 2] = Heap[j]; // 父节点 = 目前节点
				j = 2 * j;
			}
		}
		Heap[j / 2] = Temp; // 父节点 = Root值
	}

	public static void heapSort(int Index) {
		int i, j, Temp;
		// 将二叉树转成Heap
		for (i = (Index / 2); i >= 1; i--)
			CreateHeap(i, Index);
		// 开始进行堆排序
		for (i = Index - 1; i >= 1; i--) {
			Temp = Heap[i + 1]; // Heap的Root值和最后一个值交换
			Heap[i + 1] = Heap[1];
			Heap[1] = Temp;
			CreateHeap(1, i); // 对其余数值重建堆
			System.out.print("排序中: ");
			for (j = 1; j <= Index; j++)
				System.out.printf("%3s", Heap[j]);
			System.out.println("");
		}
	}

}
