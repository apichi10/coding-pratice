package leetcode;

public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = new int[]{2,4,0,0,2,0,5};
		//backward(nums);
		forward(nums);
		for (int i : nums) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
	
	public static void forward(int[] nums) {
		int cur = nums.length-1;
		for(int i=nums.length-1; i >= 0; i--) {
			if(nums[i]!=0) {
				nums[cur] = nums[i];
				cur--;
			}
		}
		while(cur >= 0) {
			nums[cur] = 0;
			cur--;
		}
	}
	
	public static void backward(int[] nums) {
		int cur = 0;
		for(int i=0; i < nums.length; i++) {
			if(nums[i]!=0) {
				nums[cur] = nums[i];
				cur++;
			}
		}
		while(cur < nums.length) {
			nums[cur] = 0;
			cur++;
		}
	}
}
