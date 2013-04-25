package com.taven.algorithm;

/**
 * 二叉树排序算法
 * 
 * 排序二叉树的描述也是一个递归的描述， 所以排序二叉树的构造自然也用递归的：
 * 
 * 排序二叉树的3个特征：
 * 当前node的所有左孩子的值都小于当前node的值；
 * 当前node的所有右孩子的值都大于当前node的值；
 * 孩子节点也满足以上两点
 * 
 * @author Taven.Li
 *
 */
public class BinaryTreeSort {

    private int value;//current value  
	private BinaryTreeSort lChild;//left child  
    private BinaryTreeSort rChild;//right child  
      
    public BinaryTreeSort(int value, BinaryTreeSort l, BinaryTreeSort r){  
        this.value = value;  
        this.lChild = l;  
        this.rChild = r;  
    }  
      
    public BinaryTreeSort getLChild() {  
        return lChild;  
    }  
    public void setLChild(BinaryTreeSort child) {  
        lChild = child;  
    }  
    public BinaryTreeSort getRChild() {  
        return rChild;  
    }  
    public void setRChild(BinaryTreeSort child) {  
        rChild = child;  
    }  
    public int getValue() {  
        return value;  
    }  
    public void setValue(int value) {  
        this.value = value;  
    }  
      
    //iterate all node.  
    public static void iterate(BinaryTreeSort root){  
        if(root.lChild!=null){  
            iterate(root.getLChild());  
        }  
        System.out.print(root.getValue() + " ");  
        if(root.rChild!=null){  
            iterate(root.getRChild());  
        }  
    }  
      
    /** 
     * add child to the current node to construct a tree. 
     * Time: O( nlog(n) ) 
     * **/  
    public void addChild(int n){  
        if(n<value){  
            if(lChild!=null){  
                lChild.addChild(n);  
            }  
            else{  
                lChild = new BinaryTreeSort(n, null, null);  
            }  
        }  
        else{  
            if(rChild!=null){  
                rChild.addChild(n);  
            }  
            else{  
                rChild = new BinaryTreeSort(n, null, null);  
            }  
        }  
    }  
      
	public static void main(String[] args) {
		System.out.println();
		int[] arr = new int[] { 23, 54, 1, 65, 9, 3, 100 };
		BinaryTreeSort root = new BinaryTreeSort(arr[0], null, null);
		for (int i = 1; i < arr.length; i++) {
			root.addChild(arr[i]);
		}
		BinaryTreeSort.iterate(root);
	}

}
