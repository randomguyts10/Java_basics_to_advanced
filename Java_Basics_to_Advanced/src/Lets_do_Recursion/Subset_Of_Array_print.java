package Lets_do_Recursion;

import java.util.Iterator;

public class Subset_Of_Array_print {

	public static void printsubset(int[] arr) {
		
		int[] outputSoFar = new int[0]; // empty array
		printsubset(arr, 0, outputSoFar);
	}
	public static void printsubset(int[] arr, int si, int[] outputSoFar) {
		
		// Key Point
		if (si >= arr.length) {
			for (int i = 0; i < outputSoFar.length; i++) {
				System.out.print(outputSoFar[i] + " ");
			}
			System.out.println();
			return;
		}
		 
		int[] partOfOut = new int[outputSoFar.length + 1];
		
//		partOfOut[0] = arr[si]; 
		for (int i = 0; i < outputSoFar.length; i++) {
			partOfOut[i] = outputSoFar[i];
		}
		partOfOut[partOfOut.length - 1] = arr[si];
		
		printsubset(arr, si + 1, outputSoFar);
		printsubset(arr, si + 1, partOfOut);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {15, 20, 30};
		printsubset(arr);
	}
	
}
