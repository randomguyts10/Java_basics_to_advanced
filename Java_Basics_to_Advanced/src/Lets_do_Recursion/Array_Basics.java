package Lets_do_Recursion;

public class Array_Basics {
	
	public static void print(int[] arr, int si)
	{
		if (si == arr.length) {
			return;
		}
		System.out.print(arr[si] + " ");
		print(arr, si + 1);
		System.out.print(arr[si] + " ");

	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 4 ,5 ,6};
		print(arr, 0);
	}

}
