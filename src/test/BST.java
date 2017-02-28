package test;

import java.util.ArrayList;
/*
 * Liwei Lin
 * ID 166836
 * 
 * */
class TreeNode {

	Comparable<Integer> element; // The data in the node
	TreeNode left; // Left child
	TreeNode right; // Right child

	TreeNode(Comparable<Integer> theElement) {
		element = theElement;
		left = right = null;
	}

}

public class BST {
	protected TreeNode root;

	public BST() {
		root = null;
	}

	public void search(Comparable<Integer> com){
		search(com,root);
	}
	
	private TreeNode search(Comparable<Integer> com, TreeNode treeNode) {
		while (treeNode != null) {
			if (com.compareTo((Integer) treeNode.element) < 0){
				treeNode = treeNode.left;
			}else if (com.compareTo((Integer) treeNode.element) > 0){
				treeNode = treeNode.right;
			}else{
				return treeNode;
			}
		}

		return null;
	}
	
	public void searchPath(Comparable<Integer> com){
		System.out.println(searchPath(com, root).toString());

	}
	
	private ArrayList<String> searchPath(Comparable<Integer> com, TreeNode treeNode) {
		 ArrayList<String> path = new  ArrayList<String> ();
		while (treeNode != null) {
			if (com.compareTo((Integer) treeNode.element) < 0){
				path.add(treeNode.element+" ->left ");
				treeNode = treeNode.left;
			}else if (com.compareTo((Integer) treeNode.element) > 0){
				path.add(treeNode.element+ " ->right ");

				treeNode = treeNode.right;
			}else{
				path.add(treeNode.element.toString());
				return path;
			}
		}

		return path;
	}

	public void insert(Comparable<Integer> com) throws Exception {
		root = insert(com, root);
	}
	
	public void delete(Comparable<Integer> com) throws Exception {
		root = delete(com, root);
	}

	public TreeNode insert(Comparable<Integer> com, TreeNode treeNode)
			throws Exception {
		if (treeNode == null)
			treeNode = new TreeNode(com);
		else if (com.compareTo((Integer) treeNode.element) < 0)
			treeNode.left = insert(com, treeNode.left);
		else if (com.compareTo((Integer) treeNode.element) > 0)
			treeNode.right = insert(com, treeNode.right);
		else
			throw new Exception();
		return treeNode;
	}

	protected TreeNode delete(Comparable<Integer> com, TreeNode treeNode)
			throws Exception {
		if (treeNode == null)
			throw new Exception();
		if (com.compareTo((Integer) treeNode.element) < 0)
			treeNode.left = delete(com, treeNode.left);
		else if (com.compareTo((Integer) treeNode.element) > 0)
			treeNode.right = delete(com, treeNode.right);
		else if (treeNode.left != null && treeNode.right != null) // Two
																	// children
		{
			treeNode.element = searchMin(treeNode.right).element;
			treeNode.right = deleteMin(treeNode.right);
		} else
			treeNode = (treeNode.left != null) ? treeNode.left : treeNode.right;
		return treeNode;
	}

	protected TreeNode searchMin(TreeNode t) {
		if (t != null)
			while (t.left != null)
				t = t.left;

		return t;
	}

	protected TreeNode deleteMin(TreeNode treeNode) throws Exception {
		if (treeNode == null)
			throw new Exception();
		else if (treeNode.left != null) {
			treeNode.left = deleteMin(treeNode.left);
			return treeNode;
		} else
			return treeNode.right;
	}


	public static void DisplayAsTreeOrder(TreeNode tn, int level) {
		if (tn == null)
			return;
		if (level == 1)
			System.out.print(tn.element + " ");
		else if (level > 1) {
			DisplayAsTreeOrder(tn.left, level - 1);
			DisplayAsTreeOrder(tn.right, level - 1);
		}
	}

	public void printOrderByLevel() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			DisplayAsTreeOrder(root, i);
		System.out.println();
	
	}

	int height(TreeNode root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	public void postOrderDisplay(TreeNode tn) {
		if (tn == null) {
			return;
		}
		postOrderDisplay(tn.left);
		postOrderDisplay(tn.right);
		System.out.print(tn.element+" ");
	}

	public void preOrderDisplay(TreeNode tn) {
		if (tn == null) {
			return;
		}
		System.out.print(tn.element+" ");
		preOrderDisplay(tn.left);
		preOrderDisplay(tn.right);
	}

	public static void main(String[] args) throws Exception {
		BST t = new BST();

		t.insert(new Integer(40));
		t.insert(new Integer(25));
		t.insert(new Integer(78));
		t.insert(new Integer(10));
		t.insert(new Integer(3));
		t.insert(new Integer(17));
		t.insert(new Integer(32));
		t.insert(new Integer(30));
		t.insert(new Integer(38));
		// t.insert(new Integer(78));
		t.insert(new Integer(50));
		t.insert(new Integer(93));
		
		System.out.println("Display as Tree order:");
		t.printOrderByLevel();
		System.out.println("\nPreOrder:");
		t.preOrderDisplay(t.root);
		System.out.println("\n\nPostOrder:");
		t.postOrderDisplay(t.root);
		System.out.println("\n\nNode Path:");
		t.searchPath(new Integer(32));
		System.out.println();

	}

}

