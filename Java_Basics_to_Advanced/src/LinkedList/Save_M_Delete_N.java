package LinkedList;

import java.util.Scanner;

public class Save_M_Delete_N {
	
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> input()
	{
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		
		while(data != -1)
		{
			Node<Integer> currentNode = new Node<Integer>(data);
			
			if (head == null) {
				// Make head and tail the current node
				head = currentNode;
				tail = currentNode;
			} else {
				tail.next = currentNode; // Make before Break Rule
				tail = currentNode;
			}
			data = sc.nextInt();
			
		}
		
		return head;
	}

	public static Node<Integer> SaveMdeleteN(Node<Integer> head, int M, int N)
	{
		// Edge Case
		if (M == 0 || head == null) {
			return null;
		}
		if (N == 0) {
			return head;
		}
		
		Node<Integer> temp1 = head;
		Node<Integer> temp2 = null;
		
		while (true) {
			int count1 = 1;
			int count2 = 1;
			
			while (temp1 != null && count1 < M) {
				temp1 = temp1.next;
				count1++;
			}
			temp2 = temp1.next;
			while (temp2 != null && count2 < N) {
				temp2 = temp2.next;
				count2++;
			}
			
			if (temp2 != null) {
				temp2 = temp2.next;
				temp1.next = temp2;
				temp1 = temp1.next;
			}
			
			if (temp1 == null || temp2 == null) {
				break;
			}
			
		}
		if (temp1 != null) {
			temp1.next = null;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = input();
		Node<Integer> head2 = SaveMdeleteN(head, 2, 2);
		print(head2);
	}

}
