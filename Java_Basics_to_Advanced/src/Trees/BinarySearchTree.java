package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
	
	public static BinaryTreeNode<Integer> takeInputLevelwise()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root: ");
		int rootData = sc.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pc = new LinkedList<BinaryTreeNode<Integer>>();
		pc.add(root);
		
		while (!pc.isEmpty()) {
			BinaryTreeNode<Integer> front = pc.poll();
			System.out.println("Enter the left child of: " + front.data);
			int leftData = sc.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				front.left = left;
				pc.add(left);
			}
			
			System.out.println("Enter the right child of: " + front.data);
			int rightData = sc.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				front.right = right;
				pc.add(right);
			}
			
		}
		return root;
	}

	public static void printIfPresent(BinaryTreeNode<Integer> root, int k)
	{
		if (root == null) {
			return;
		}
		if (root.data == k) {
			System.out.print(root.data + " ");
			return;			
		}
		
		if (root.data < k) {
			printIfPresent(root.right, k);
		}else
		{
			printIfPresent(root.left, k);
		}
	}
	
	public static void printFromK1toK2(BinaryTreeNode<Integer> root, int k1, int k2)
	{
		int start = Math.min(k1, k2);
		int end = Math.max(k1, k2);

		if (k1 == k2) {
			printIfPresent(root, k2);
		}else
		{
			printFromK1toK2Helper(root, start, end);
		}
		
	}
	
	public static void printUp(BinaryTreeNode<Integer> root, int k)
	{
		if (root == null) {
			return;
		}
		if (root.data >= k) {
			printUp(root.left, k);
			System.out.print(root.data + " ");
		}else {
			System.out.print(root.data + " ");
			printUp(root.right, k);
		}
	}
	
	public static void printDown(BinaryTreeNode<Integer> root, int k)
	{
		if (root == null) {
			return;
		}
		if (root.data <= k) {
			System.out.print(root.data + " ");
			printDown(root.right, k);
		}else {
			System.out.print(root.data + " ");
			printDown(root.left, k);
		}
	}
	public static void printWhole(BinaryTreeNode<Integer> root, int k)
	{
		if (root == null) {
			return;
		}
		if (root.data >= k) {
			System.out.print(root.data + " ");
			printDown(root.right, k);
		}else {
			System.out.print(root.data + " ");
			printDown(root.left, k);
		}
	}
	
	public static void printFromK1toK2Helper(BinaryTreeNode<Integer> root, int k1, int k2)
	{
		if (root == null) {
			return;
		}
		
		if (k1 <= root.data && k2 >= root.data)
		{	
			printFromK1toK2Helper(root.left, k1, k2);
			System.out.print(root.data + " ");
			printFromK1toK2Helper(root.right, k1, k2);
		}
		else if (root.data < k1) {
			printFromK1toK2(root.right, k1, k2);
		} 
		else if (root.data > k2)
		{
			printFromK1toK2(root.left, k1, k2);
		}
		
		
		
	}

	
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelwise();
		int k1 = 6;
		int k2 = 10;
		printFromK1toK2(root, k1, k2);
//		printDown(root, k2);
//		System.out.println();
//		printUp(root, k1);
	}
	

}
