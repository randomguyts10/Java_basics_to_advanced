package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



class LargestBSTReturn
{
	int max;
	int min;
	boolean isBST;
	int height;
	int heightBST;
	
	public LargestBSTReturn(int max, int min, boolean isBST, int height, int heightBST) {
		this.max = max;
		this.min = min;
		this.isBST = isBST;
		this.height = height;
		this.heightBST = heightBST;
	}
}
public class Assignment {
	
	
	private static int countNodes(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return 0;
		}
		
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	// To push nodes with data just greater than the root data
	private static void JustGreater(Stack<BinaryTreeNode<Integer>> stk, BinaryTreeNode<Integer> root)
	{
		if (root.right != null) {
			root = root.right;
			while(root != null)
			{
				stk.push(root);
				root = root.left;
			}
		}
	
	}
	
	// To push nodes with data just smaller than the root data
	private static void JustSmaller(Stack<BinaryTreeNode<Integer>> stk, BinaryTreeNode<Integer> root)
	{
		if (root.left != null) {
			root = root.left;
			while(root != null)
			{
				stk.push(root);
				root = root.right;
			}
		}
	
	}

	public static void PairSumPrint(BinaryTreeNode<Integer> root, int S)
	{
		if(root == null)
		{
			return;
		}
		
		int totalNodes = countNodes(root);
		
		int count = 0;
		Stack<BinaryTreeNode<Integer>> inOrder = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> RevinOrder = new Stack<BinaryTreeNode<Integer>>();
		
		BinaryTreeNode<Integer> temp = root;
		
		while (temp != null) {
			inOrder.push(temp);
			temp = temp.left;
		}
		temp = root;
		
		while (temp != null) {
			RevinOrder.push(temp);
			temp = temp.right;
		}
		
		while(count < totalNodes - 1)
		{
			BinaryTreeNode<Integer> top1 = inOrder.peek();
			BinaryTreeNode<Integer> top2 = RevinOrder.peek();
			
			if (top1.data + top2.data == S) {
				System.out.println(top1.data + " " + top2.data);
				
				BinaryTreeNode<Integer> top = top1;
				inOrder.pop();
				count++;
				JustGreater(inOrder, top);
				
				top = top2;
				RevinOrder.pop();
				count++;
				JustSmaller(RevinOrder, top);
				
			}
			else if(top1.data + top2.data > S)
			{
				BinaryTreeNode<Integer> top = top2;
				RevinOrder.pop();
				count++;
				JustSmaller(RevinOrder, top);			}
			else
			{
				BinaryTreeNode<Integer> top = top1;
				inOrder.pop();
				count++;
				JustGreater(inOrder, top);
			}
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static LargestBSTReturn LargestBSTbetter(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return new LargestBSTReturn(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
		}
		
		LargestBSTReturn left = LargestBSTbetter(root.left);
		LargestBSTReturn right = LargestBSTbetter(root.right);
		
		int max = Math.max(root.data, Math.max(left.max, right.max));
		int min = Math.min(root.data, Math.min(left.min, right.min));
		int heightBST;
		
		
		int height = 1 + Math.max(left.height, right.height);
		boolean isBST = true;
		
		if (root.data <= left.max || root.data > right.min) {
			isBST = false;
		}
		
		if (!left.isBST || !right.isBST) {
			isBST = false;
		}
		if (isBST) {
			heightBST = height;
		}else
		{
			heightBST = Math.max(left.heightBST, right.heightBST);
		}
		
		
		LargestBSTReturn ans = new LargestBSTReturn(max, min, isBST, height, heightBST);
		return ans;
		
	}
	
	
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

	
	
	private static int height(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
		
	}
	
	
	private static boolean isBST(BinaryTreeNode<Integer> root)
	{
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		return isBSTHelper(root, min, max);
		
	}
	
	private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int min, int max)
	{
		if (root == null) {
			return true;
		}
		
		if (root.data < min || root.data > max) {
			return false;
		}
		
		boolean left = isBSTHelper(root.left, min, root.data - 1);
		boolean right = isBSTHelper(root.right, root.data, max);
		
		
		return (left && right);
		
	}
	
	public static int largestBST(BinaryTreeNode<Integer> root)
	{
		if (isBST(root)) {
			return height(root);
		}
		
		int largestLeft = largestBST(root.left);
		int largestRight = largestBST(root.right);
		
		return Math.max(largestLeft, largestRight);
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInputLevelwise();
//		printInputLevelwise(root);
//		System.out.println(largestBST(root));
		
//		
//		LargestBSTReturn ans = LargestBSTbetter(root);
//		System.out.println(ans.heightBST);
//		
		PairSumPrint(root, 25);
		
	}

}
