package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Reverse_First_K {
	
	public static void reverse(Queue<Integer> q, int k)
	{
		if (k == 0) {
			return;
		}
		int frontelem = q.poll();
		reverse(q, k - 1);
		q.add(frontelem);
	}
	
	
	public static Queue<Integer> reverse_k(Queue<Integer> q, int k)
	{
		// Reverse Queue
		reverse(q, k);
		
		int m = q.size() - k;
		while(m > 0)
		{
			q.add(q.poll());
			m--;
		}
		
		return q;
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		int arr[] = {1,2,3,4,5,6,7};
		
		for (int i : arr) {
			q.add(i);
		}
		
		System.out.println(q);
//		reverse(q);
		Queue<Integer> q2 = reverse_k(q, 3);
		System.out.println(q2);
	}

}
