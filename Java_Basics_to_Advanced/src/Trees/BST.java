package Trees;

public class BST {
	
	private BinaryTreeNode<Integer> root;
	private int size;
	
	private static boolean isPresent(BinaryTreeNode<Integer> root, int x)
	{
		if (root == null) {
			return false;
		}
		
		if (root.data == x) {
			return true;
		}
		
		if (root.data < x) {
			return isPresent(root.right, x);
		} else {
			return isPresent(root.left, x);
		}
	}
	
	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x)
	{
		if (node == null) {
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<Integer>(x);
			return newRoot;
		}
		
		if (x >= node.data) {
			node.right = insert(node.right, x);
		} else {
			node.left = insert(node.left, x);
		}
		return node;
	}
	
	private static void printTree(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return;
		}
		System.out.print(root.data + ": ");
		
		if (root.left != null) {
			System.out.print("L = " + root.left.data + " ");
		}
		
		if (root.right != null) {
			System.out.print("R = " + root.right.data);
		}
		System.out.println();
		
		printTree(root.left);
		printTree(root.right);
		
	}

	private static int smallest(BinaryTreeNode<Integer> root)
	{
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		int smallestLeft = smallest(root.left);
		int smallestRight = smallest(root.right);
		
		return Math.min(root.data, Math.min(smallestLeft, smallestRight));
	}
	private static BSTDeleteReturn deleteData(BinaryTreeNode<Integer> root, int x)
	{
		if (root == null) {
			return new BSTDeleteReturn(null, false);
		}
		
		if (root.data < x) {
			BSTDeleteReturn outputRight = deleteData(root.right, x);
			root.right = outputRight.root;
			outputRight.root = root;
			return outputRight;
		}
		
		if (root.data > x) {
			BSTDeleteReturn outputLeft = deleteData(root.left, x);
			root.left = outputLeft.root;
			outputLeft.root = root;
			return outputLeft;
		}		
		
		// 0 children
		if (root.left == null && root.right == null) {
			return new BSTDeleteReturn(null, true);
		}
		
		// only left child
		if (root.left != null && root.right == null) {
			return new BSTDeleteReturn(root.left, true);
		}
		// only right child
		if (root.left == null && root.right != null) {
			return new BSTDeleteReturn(root.right, true);
		}

		// Both the children are present
		int rightMin = smallest(root.right);
		root.data = rightMin;
		BSTDeleteReturn outputRight = deleteData(root.right, rightMin);
		root.right = outputRight.root;
		
		return new BSTDeleteReturn(root, true);
	}

	public boolean deleteData(int x)
	{
		BSTDeleteReturn out = deleteData(root, x);
		root = out.root;
		if (out.deleted) {
			size--;
		}
		return out.deleted;
	}
	
	public boolean isPresent(int x)
	{
		return isPresent(root, x);
	}
	
	public void insert(int x)
	{
		root = insert(root, x);
		size++;
	}
	
	public int size()
	{
		return size;
	}
	
	public void printTree()
	{
		printTree(root);
	}
}
