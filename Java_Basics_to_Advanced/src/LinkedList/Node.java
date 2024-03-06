package LinkedList;

public class Node<T> {

	T data;
	Node<T> next;
	
	Node(T data)
	{
		this.data = data;
//		this.next = null; // By default null so no need to write this line;
	}
}
