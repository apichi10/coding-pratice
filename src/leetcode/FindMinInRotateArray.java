package leetcode;

public class FindMinInRotateArray {

	/*
		Suppose a sorted array is rotated at some pivot unknown to you beforehand.
		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		Find the minimum element.

		You may assume no duplicate exists in the array.
	*/
	public static void main(String[] args) {
		FindMinInRotateArray f = new FindMinInRotateArray(); 
		System.out.println(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
		System.out.println(f.findMin(new int[]{1,0}));
		System.out.println(f.findMin(new int[]{0,1}));
		System.out.println(f.findMin(new int[]{2,3,1}));
		System.out.println(f.findMin(new int[]{3,1,2}));
		System.out.println(f.findMin(new int[]{1,2,3}));
	}
	
	public int findMin(int[] num) {
		int low = 0, hi = num.length-1;
		
		while(low<hi)
		{
			int mid = (low+hi)/2;
			if(num[mid]<num[hi])
				hi = mid;
			else
				low = mid+1;
		}
		return num[hi];
    }
	
	/*
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		
		int beg = 0, end = nums.length-1;
		while(beg <= end) {
			int mid = (beg + end)/2;
			if(mid != 0 && (nums[mid-1] > nums[mid]) )
				return nums[mid];
			else if(nums[mid] >= nums[beg] && nums[mid] > nums[end])
				beg = mid + 1;
			else
				end = mid -1;
		}
		return nums[0];
    }
    */
}
