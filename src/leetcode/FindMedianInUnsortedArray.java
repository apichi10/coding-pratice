package leetcode;

public class FindMedianInUnsortedArray {

	public static void main(String[] args) {
		FindMedianInUnsortedArray f = new FindMedianInUnsortedArray();
		int[] nums = new int[]{7,9,4,5};
		System.out.println(f.median(nums));
	}
	
	public int median(int[] nums) {
		if (nums == null || nums.length==0) 
        	return -1;
		if(nums.length == 1)
			return nums[0];
		return median(nums, 0, nums.length-1, (nums.length-1)/2);
	}
	
	public int median(int[] nums, int beg, int end, int k) {
        int median = helper(nums, beg, end, k);
        if(median == k )
        	return nums[median];
        else if(median > k )		
        	return nums[helper(nums, beg, median-1, k)];
        else
        	return nums[helper(nums, median+1, end, k)];    
    }
	
	public int helper(int[] arr, int beg, int end, int k) {
		int pivot = (beg + end)/2;
		swap(arr, pivot, end);
		for(int i=beg; i <= end; i++) {
			if(arr[i] < arr[end]) {
				swap(arr, i, beg);
				beg++;
			}
		}
		swap(arr, beg, end);
		return beg;
	}
	
	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
