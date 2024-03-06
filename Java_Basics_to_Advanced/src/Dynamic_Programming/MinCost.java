package Dynamic_Programming;

import java.util.Scanner;

public class MinCost {
	
	public static int costHelper(int si_i, int si_j, int[][] arr, int m, int n)
	{
		if(si_i == m - 1 && si_j == n - 1)
		{
			return arr[si_i][si_j]; 
		}
		if (si_i >= m || si_j >= n ) {
			return Integer.MAX_VALUE;
		}
		
		int case1 = costHelper(si_i + 1, si_j, arr, m, n);
		int case2 = costHelper(si_i + 1, si_j + 1, arr, m, n);
		int case3 = costHelper(si_i, si_j + 1, arr, m, n);
		
		int min_cost = Math.min(case3, Math.min(case1, case2));
		
		int ans = arr[si_i][si_j] + min_cost;
	
		return ans;
	
	}
	
	
	public static int cost(int[][] arr, int m, int n)
	{
		int si_i = 0, si_j = 0;
		return costHelper(si_i,  si_j, arr, m, n);
	}
	
	
	public static void main(String[] args) {
		
		int[][] arr = {{3,4,1,9}, {2,10,12,3}, {8,7,8,1}};
		
//		System.out.println(cost(arr, 3, 4));
		
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int[3][4];
//		
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(cost(arr, 3, 4));

	}

}
