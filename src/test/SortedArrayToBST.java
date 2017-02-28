package test;

public class SortedArrayToBST {
	
	class TreeNode {	
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		SortedArrayToBST s = new SortedArrayToBST();
		TreeNode root = s.sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
		
		System.out.println(root);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0)
			return null;
		return sortedArrayToBST(nums, 0, nums.length-1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
		if(begin > end)
			return null;
		int mid = (begin+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, begin, mid-1);
		root.right = sortedArrayToBST(nums, mid+1, end);

		return root;
	}
}


