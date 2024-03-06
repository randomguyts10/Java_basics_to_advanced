package Lets_do_Recursion;

public class checkSorted {
	
	public static boolean checkSortedBetter(int[] arr, int startidx) {
		
		if (startidx >= arr.length - 1) {
			
			return true;
		}
		
		if (arr[startidx] > arr[startidx + 1]) {
			
			return false;
		}
		 boolean smallout = checkSortedBetter(arr, startidx + 1);
		 
		 return smallout;
	}
	
	// Helper Function
	public static boolean checkSortedBetter(int[] arr) {
				 
		 return checkSortedBetter(arr, 0);
	}	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,7,8,9};
		System.out.println(checkSortedBetter(arr));
	}

}
