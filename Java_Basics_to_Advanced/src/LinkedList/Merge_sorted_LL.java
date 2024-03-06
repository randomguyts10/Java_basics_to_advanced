package LinkedList;

import java.util.Scanner;

public class Merge_sorted_LL {

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

	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2)
	{
		Node<Integer> t1 = head1;
		Node<Integer> t2 = head2;
		Node<Integer> head;
		
		// For Creating the Merged Linked List
		if (t1.data <= t2.data ) {
			head = new Node<>(t1.data);
			t1 = t1.next;
		} else {
			head = new Node<>(t2.data);
			t2 = t2.next;
		}
		Node<Integer> temp = head;
		
		while(t1 != null && t2 != null)
		{
			if (t1.data <= t2.data ) {
				Node<Integer> newnode = new Node<>(t1.data);
				temp.next = newnode;
				temp = temp.next;  // or temp = newnode;
				t1 = t1.next;
			} else {
				Node<Integer> newnode = new Node<>(t2.data);
				t2 = t2.next;
				temp.next = newnode;
				temp = temp.next;  // or temp = newnode;
			}

		}

		while(t1 != null)
		{
			Node<Integer> newnode = new Node<>(t1.data);
			temp.next = newnode;
			temp = temp.next;  // or temp = newnode;
			t1 = t1.next;
		}

		while(t2 != null)
		{
			Node<Integer> newnode = new Node<>(t2.data);
			t2 = t2.next;
			temp.next = newnode;
			temp = temp.next;  // or temp = newnode;

		}
		
		
		return head;
	}
	
	
	
	public static Node<Integer> merge_better(Node<Integer> head1, Node<Integer> head2)
	{
		Node<Integer> t1 = head1;
		Node<Integer> t2 = head2;
		Node<Integer> head;
		
		// For Creating the Merged Linked List
		if (t1.data <= t2.data ) {
			head = t1;
			t1 = t1.next;
		} else {
			head = t2;
			t2 = t2.next;
		}
		Node<Integer> temp = head;
		
		while(t1 != null && t2 != null)
		{
			if (t1.data <= t2.data ) {
				temp.next = t1;
				temp = temp.next;
				t1 = t1.next;
			} else {
				
				temp.next = t2;
				temp = temp.next;
				t2 = t2.next;
			}

		}

		if (t1 != null)
		{			
			temp.next = t1;
		}

		if(t2 != null)
		{
			temp.next = t2;
		}
		
		
		return head;
	}

	public static void main(String[] args) {
		
		Node<Integer> head1 = input();
		Node<Integer> head2 = input();
		Node<Integer> head = merge_better(head1, head2);
		print(head);
	}
}
