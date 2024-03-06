package LinkedList;

import java.util.Scanner;

public class LL_USe {

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
	
	public static Node<Integer> insert(Node<Integer> head, int data, int pos)
	{
//		int count = 0;
		Node<Integer> ntbi = new Node<>(data);
		
		if (pos == 0) {
			
			ntbi.next = head;
			head = ntbi;
		} else {
			int count = 0;
			Node<Integer> prev = head;
			while (prev != null && count < pos - 1) {
				count++;
				prev = prev.next;
			}
			if (prev != null) {
				ntbi.next = prev.next;
				prev.next = ntbi;
			}

		}
		return head;
	}
	
	public static int findNode(Node<Integer> head, int num)
	{
		int count = 0;
		Node<Integer> temp = head;
		
		while(temp != null)
		{
			if (temp.data == num) {
				return count;
			}
			count++;
			temp = temp.next;
		}
		
		return -1;
		
	}
	
	public static Node<Integer> append_N(Node<Integer> head, int N)
	{
		Node<Integer> temp1 = head;
		Node<Integer> tail = null;
		
		int count = 0;
		
		while(temp1 != null)
		{
			count++;
			tail = temp1;
			temp1 = temp1.next;
			
		}
		
//		tail = temp1;
		int new_head_idx = count - N;
		
		Node<Integer> temp2 = head;
		for (int i = 0; i < new_head_idx - 1 ; i++) {
			temp2 = temp2.next;
		}
		
		 Node<Integer> new_head = temp2.next; // new head
		 Node<Integer> new_tail = temp2;
		 
		 // making the new tail
		 new_tail.next = null;
		 
		 // connecting the previous tail to head
		 tail.next = head;
		 
		 return new_head;
	}
	
	public static Node<Integer> reverse(Node<Integer> head)
	{
		Node<Integer> previous = null;
		Node<Integer> current = head;
		Node<Integer> after = null;
		
		
		return head;
		
	}

	public static void print_reverse(Node<Integer> head)
	{
		if (head == null) {
			return;
		}
		print_reverse(head.next);
		System.out.print(head.data + " ");
	}

	public static int midpoint(Node<Integer> head)
	{
		if (head == null || head.next == null) {
			return -1;
		}
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		
		while (fast.next != null && fast.next.next != null) 
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
	public static void main(String[] args) {
		
		Node<Integer> head = input();
		print(head);
//		Node<Integer> head_2 = insert(head, 20, 3);
//		print(head_2);
		
//		System.out.println(findNode(head, 8));
		
//		Node<Integer> head_3 = append_N(head, 5);
//		System.out.println("Reverse");
		System.out.println(midpoint(head));
	}
}
