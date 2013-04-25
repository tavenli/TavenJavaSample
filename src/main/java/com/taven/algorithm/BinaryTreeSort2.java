package com.taven.algorithm;

/**
 * 二叉树排序 
 * 
 * @author Taven.Li
 *
 */
public class BinaryTreeSort2 {

	  public static int[] a = { 0, 10, 32, 1, 9, 5, 7, 12, 2, 4, 3 }; // 预设数据数组    
	  public static int[] Data = new int[20]; // 预设数据数组    
	   
	  public static void main(String args[]) {    
	    int i; // 循环计数变量    
	    int Index = 1; // 数据索引变量    
	    BNTreeArray BNTree = new BNTreeArray(); // 声明二叉树数组    
	   
	    Data[Index] = a[Index];    
	    BNTreeArray.TreeData[0] = Data[Index];    
	    Index++;    
	    for (i = 2; i < a.length; i++) {    
	      Data[Index] = a[Index];    
	      BNTree.Create(Data[Index]); // 建立二叉查找树    
	      Index++;    
	    }    
	   
	    // 排序前数据内容    
	    System.out.print("排序前 : ");    
	    for (i = 1; i < Index; i++)    
	      System.out.print(" " + Data[i] + " ");    
	    System.out.println("");    
	   
	    // 排序后结果    
	    System.out.print("排序后 : ");    
	    BNTreeArray.InOrder(0); // 中序遍历    
	  }    
	}    
	   
	class BNTreeArray {    
	  public static int MaxSize = 20;    
	  public static int[] TreeData = new int[MaxSize];    
	  public static int[] RightNode = new int[MaxSize];    
	  public static int[] LeftNode = new int[MaxSize];    
	   
	  public BNTreeArray() {    
	    int i; // 循环计数变量    
	   
	    for (i = 0; i < MaxSize; i++) {    
	      TreeData[i] = 0;    
	      RightNode[i] = -1;    
	      LeftNode[i] = -1;    
	    }    
	  }    
	   
	  // ----------------------------------------------------    
	  // 建立二叉树    
	  // ----------------------------------------------------    
	  public void Create(int Data) {    
	    int i; // 循环计数变量    
	    int Level = 0; // 树的阶层数    
	    int Position = 0;    
	   
	    for (i = 0; TreeData[i] != 0; i++)    
	      ;    
	   
	    TreeData[i] = Data;    
	    while (true) // 寻找节点位置    
	    {    
	      // 判断是左子树或是右子树    
	      if (Data > TreeData[Level]) {    
	        // 右树是否有下一阶层    
	        if (RightNode[Level] != -1)    
	          Level = RightNode[Level];    
	        else {    
	          Position = -1; // 设定为右树    
	          break;    
	        }    
	      } else {    
	        // 左树是否有下一阶层    
	        if (LeftNode[Level] != -1)    
	          Level = LeftNode[Level];    
	        else {    
	          Position = 1; // 设定为左树    
	          break;    
	        }    
	      }    
	    }    
	   
	    if (Position == 1) // 建立节点的左右连结    
	      LeftNode[Level] = i; // 连结左子树    
	    else   
	      RightNode[Level] = i; // 连结右子树    
	  }    
	   
	  // ---------------------------------------------------------    
	  // 二叉树中序遍历    
	  // ---------------------------------------------------------    
	  public static void InOrder(int Pointer) {    
	    if (Pointer != -1) // 遍历的终止条件    
	    {    
	      InOrder(LeftNode[Pointer]); // 处理左子树    
	      // 处理打印节点内容    
	      System.out.print(" " + TreeData[Pointer] + " ");    
	      InOrder(RightNode[Pointer]); // 处理右子树    
	    }    
	  }    
	  
}
