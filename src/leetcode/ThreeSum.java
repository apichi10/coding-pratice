package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		//List<List<Integer>> result = ts.threeSum(new int[]{-5,-5,-1,0,1,2,3});
		List<List<Integer>> result = ts.threeSum(new int[]{-5,-5,-1,0,1,2,3});
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i=0; i < nums.length-2; i++) {
			if(i>0 && nums[i] == nums[i-1])
				continue;
			int lo = i+1, hi=nums.length-1, total;
			while(lo < hi) {
				total = nums[i] + nums[lo] + nums[hi];
				if(total == 0)
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
				if(total > 0) {
					hi--;
					while(lo < hi && nums[hi] == nums[hi+1]) hi--;
				} else {
					lo++;
					while(lo < hi && nums[lo] == nums[lo-1]) lo++;
				}
			}
		}
		return result;
	}
}
