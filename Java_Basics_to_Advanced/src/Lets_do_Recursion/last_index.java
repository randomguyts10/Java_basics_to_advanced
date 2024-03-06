package Lets_do_Recursion;

public class last_index {
	
	public static int lastidx(int arr[], int num, int startidx)
	{
		 if (arr[startidx] != num && startidx <= 0) {
			 return -1;
		}
		
		 if (arr[startidx] == num) {
			 
			 return startidx;
			
		}
			return lastidx(arr, num, startidx - 1);
	 }

	public static int lastidxnew(int arr[], int num, int startidx)
	{
		 if (startidx == arr.length)  {
			 return -1;
		}
		int smallout = lastidxnew(arr, num, startidx + 1);
		if (smallout != -1) {
			return smallout;
		}
		if (arr[startidx] == num) {
			 
			return startidx ;
		}else {
			return -1;
		}
	 }

		
	 
	 
	 
	 public static void main(String[] args) {
		
		 int[] arr = {1,2,7,5,7,2};
		 int num = 7;
//		 int length = arr.length;
		 System.out.println(lastidxnew(arr, num, 0));
	}

}
