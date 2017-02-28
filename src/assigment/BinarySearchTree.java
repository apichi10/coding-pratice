package assigment;

import java.util.ArrayList;
import java.util.List;

/*
 * 1.2 Binary Search Trees
 * 1. Call printTree(bst.root) to print the tree in level order
 * 2. Call preorderTreeWalk(bst.root) or postorderTreeWalk(bst.root)
 * 3. Call pathToNode(bst.root, key) will print the path to the node
 * 
 */

public class BinarySearchTree {
	
	public TreeNode root;
	public BinarySearchTree(TreeNode root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(new TreeNode(5, null, null, null));
		addChild(8,bst.root);
		addChild(2,bst.root);
		addChild(3,bst.root);
		addChild(7,bst.root);
		addChild(6,bst.root);
		printTree(bst.root);
		
		System.out.print("Preorder: ");
		preorderTreeWalk(bst.root);
		System.out.println();
		System.out.print("Postorder: ");
		postorderTreeWalk(bst.root);
		System.out.println();
		pathToNode(bst.root, 10);
	}
	
	public static void preorderTreeWalk(TreeNode node) {
		if(node != null) {
			System.out.print(node.value + " ");
			preorderTreeWalk(node.left);
			preorderTreeWalk(node.right);
		}
	}
	
	public static void postorderTreeWalk(TreeNode node) {
		if(node != null) {
			postorderTreeWalk(node.left);
			postorderTreeWalk(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	public static void pathToNode(TreeNode root, int key) {
		TreeNode node = root;
		List<Integer> path = new ArrayList<>();
		while(node != null && node.value != key) {
			path.add(node.value);
			if(node.value > key)
				node = node.left;
			else
				node = node.right;
		}
		if(node == null) {
			System.out.println("Cannot find " + key);
			return;
		}
		path.add(key);
		System.out.print("Path to " + key + ": ");
		for (int k : path) {
			System.out.print(k + " ");
		}
	}
	
	//Print in level order
	public static void printTree(TreeNode node) {
		List<List<TreeNode>> list = new ArrayList<>();
		if(node != null)
			printTreeHelper(node, 0, list);
		for (List<TreeNode> level : list) {
			for (TreeNode treeNode : level)
				System.out.print(treeNode.value + " ");
			System.out.println();
		}
	}
	
	public static void printTreeHelper(TreeNode node, int level, List<List<TreeNode>> list) {
		if(node == null)
			return;
		while(list.size() <= level)
			list.add(new ArrayList<TreeNode>());
		list.get(level).add(node);
		printTreeHelper(node.left, level+1, list);
		printTreeHelper(node.right, level+1, list);
	}
	
	// below are the default methods
	
	public static void addChild(int value, TreeNode node) {
		if(node.value > value) {
			if(node.left != null)
				addChild(value, node.left);
			else
				node.left = new TreeNode(value, null, null, node);
		} else {
			if(node.right != null)
				addChild(value, node.right);
			else
				node.right = new TreeNode(value, null, null, node);
		}
	}
	
	public static void inorderTreeWalk(TreeNode node) {
		if(node != null) {
			inorderTreeWalk(node.left);
			System.out.print(node.value + " ");
			inorderTreeWalk(node.right);
		}
	}
	
	public static TreeNode treeSearch(int key, TreeNode node) {
		if(node != null) {
			if(key == node.value)
				return node;
			else if(key > node.value)
				return treeSearch(key, node.right);
			else
				return treeSearch(key, node.left);
		}
		return null;
	}
	
	public static TreeNode treeMax(TreeNode node) {
		while(node.right!=null)
			node = node.right;
		return node;
	}
	
	public static TreeNode treeMin(TreeNode node) {
		while(node.left != null)
			node = node.left;
		return node;
	}
	
	public static TreeNode TreeSuccessor(TreeNode node) {
		if (node == null)
            return null;
		if(node.right != null)
			return treeMin(node.right);
		TreeNode p = node.parent;
		while(p!=null && node == p.right) {
			node = p;
			p = p.parent;
		}
		return p;
	}
	
	public static TreeNode treePredeccessor(TreeNode node) {
		if (node == null)
            return null;
		if(node.left != null)
			return treeMax(node.left);
		TreeNode p = node.parent;
		while(p!=null && node == p.left) {
			node = p;
			p = p.parent;
		}
		return p;
	}
	
	public static void treeInsert(BinarySearchTree tree, TreeNode node) {
		TreeNode p = node.parent;
		TreeNode x = tree.root;
		while( x != null) {
			p = x;
			if(node.value < x.value)
				x = x.left;
			else
				x = x.right;
		}
		node.parent = p;
		if(p == null)
			tree.root = null;
		else if(node.value < p.value)
			p.left = node;
		else
			p.right = node;
	}
}


class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	public TreeNode(int value, TreeNode left, TreeNode right, TreeNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}