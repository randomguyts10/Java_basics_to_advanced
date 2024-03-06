package Lets_do_Recursion;

public class Fisrt_index {

	 public static int firstidx(int arr[], int num, int startidx)
	 {
		 if (arr[startidx] != num && startidx >= (arr.length - 1)) {
			 return -1;
		}
		
		 if (arr[startidx] == num) {
			 
			 return startidx;
			
		}else {
			return firstidx(arr, num, startidx + 1);
		}
		 
		
	 }
	 
	 
	 public static void main(String[] args) {
		
		 int[] arr = {1,2,4,5,6,7};
		 int num = 7;
		 System.out.println(firstidx(arr, num, 0));
	}
}
