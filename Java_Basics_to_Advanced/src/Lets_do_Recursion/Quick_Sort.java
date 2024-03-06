package Lets_do_Recursion;

public class Quick_Sort {
	
	public static void quicksort(int[] arr, int si, int ei) {
		
		if (si >= ei) {
			return;
		}
	
		int pp = partition(arr, si, ei);
		
		quicksort(arr, si, pp - 1);
		quicksort(arr, pp + 1, ei);
	}
	
	
	public static int partition(int[] arr, int si, int ei)
	{
		
		int count = 0;
		int pivot = arr[si];
		
		for (int i = si + 1; i <= ei; i++) {
			if (arr[i] <= pivot) {
				count++;
			}
		} 
		
		int pivotidx = si + count;
		
		arr[si] = arr[pivotidx];
		arr[pivotidx] = pivot;
		
		int i = si, j = ei;
		
		
		// Key Point
		while(i < j)
		{
			if (i <= ei && arr[i] <= pivot)
			{
				i++;
			}
			
			else if(arr[j] > pivot)
			{
				j--;
			}
			
			else if(i <= j) {
				
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
				
			}
			
		}
	
		
		return pivotidx;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 1, 2 ,8, 9, 1, 1};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		quicksort(arr, 0, arr.length - 1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
