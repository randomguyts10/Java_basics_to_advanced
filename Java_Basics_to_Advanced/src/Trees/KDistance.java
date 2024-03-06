package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KDistance {

	
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
	
	
	public static void printInputLevelwise(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return;
		}

		Queue<BinaryTreeNode<Integer>> pc = new LinkedList<BinaryTreeNode<Integer>>();
		pc.add(root);
		
		while (!pc.isEmpty()) {
			BinaryTreeNode<Integer> front = pc.poll();
			System.out.print(front.data + ": ");
			BinaryTreeNode<Integer> left = front.left;
			if (left != null) {
				System.out.print("L = " + left.data + " ");	
				pc.add(left);
			}
			
			BinaryTreeNode<Integer> right = front.right;
			if (right != null) {
				System.out.print("R = " + right.data);
				pc.add(right);
			}
			
			System.out.println();
		}
	}	
	

	public static void printInputLevelwise_NewLine(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return;
		}

		Queue<BinaryTreeNode<Integer>> pc = new LinkedList<BinaryTreeNode<Integer>>();
		pc.add(root);
		pc.add(null);
		
		while (!pc.isEmpty()) {
			BinaryTreeNode<Integer> current = pc.poll();
			if(current != null)
			{
				System.out.print(current.data + " ");
				BinaryTreeNode<Integer> left = current.left;
				BinaryTreeNode<Integer> right = current.right;
	
				if (left != null) {
					pc.add(left);
				}
				if (right != null) {
					pc.add(right);
				}
			}
			else if(current == null && pc.peek() == null) 
			{
				System.out.println();
			}
			else
			{
				System.out.println();
				pc.add(null);

			}

			
		}
	}	


	
	public static void print_at_depth_k(BinaryTreeNode<Integer> root, int k)
	{
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		
		print_at_depth_k(root.left, k - 1);
		print_at_depth_k(root.right, k - 1);
	}
	
	public static int nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k)
	{
		if (root == null) {
			return -1;
		}
		if (root.data == target) {
			print_at_depth_k(root, k);
			return 0;
		}
		
		int leftD = nodesAtDistanceK(root.left, target, k);
		if (leftD != -1) {
			if (leftD + 1 == k) {
				System.out.println(root.data);
			}else
			{
				print_at_depth_k(root.right, k - leftD - 2);
			}
			return 1 + leftD;
		}
		
		
		int rightD = nodesAtDistanceK(root.right, target, k);
		if (rightD != -1) {
			if (rightD + 1 == k) {
				System.out.println(root.data);
			}else
			{
				print_at_depth_k(root.left, k - rightD - 2);
			}
			return 1 + rightD;
		}	
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInputLevelwise();
//		printInputLevelwise_NewLine(root);
		int target = 3;
		int k = 3;
		int x = nodesAtDistanceK(root, target, k);
	}
	
	
}
