package Lets_do_Recursion;

import java.util.Iterator;

public class Subset_Of_Array {

	public static int[][] subset(int[] arr)
	{
		if (arr.length == 0) {
//			int[][] out = new int[1][0]; // empty 2D array
			int[][] out = {{}};  // empty 2D array
			return out;
		}
		int[] newarr = new int[arr.length - 1];
		for (int i = 0; i < newarr.length; i++) {
			newarr[i] = arr[i + 1];
		}
		
//		int x = arr[0];
		// sa: small answer
		int[][] sa = subset(newarr);
		
		int[][] ans = new int[2* sa.length][];
		
		int k = 0;
		for (int i = 0; i < sa.length; i++) {
			ans[k] = new int[sa[i].length]; // key point
  			for (int j = 0; j < ans[k].length; j++) {
				ans[k][j] = sa[i][j];
			}
  			k++;
		}
		
		int x = arr[0];
		for (int i = 0; i < sa.length; i++) {
			ans[k] = new int[sa[i].length + 1]; // key point
  			for (int j = 0; j < ans[k].length; j++) {
				if(j == 0) {
					ans[k][j] = x;
				}else {
					ans[k][j] = sa[i][j-1];
				}
  				
			}
  			k++;
		}
		
		return ans;

	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {15,20};
		
		int[][] subsets = subset(arr);
		
		for (int i = 0; i < subsets.length; i++) {
			for (int j = 0; j < subsets[i].length; j++) {
				System.out.print(subsets[i][j] + " ");
			}
			System.out.println();
		}
	}
}
