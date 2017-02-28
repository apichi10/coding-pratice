package leetcode;

public class TwoSumSorted {

	/*
		Given an array of integers that is already sorted in ascending order, 
		find two numbers such that they add up to a specific target number.
		
		The function twoSum should return indices of the two numbers such that they add up to the target, 
		where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
		are not zero-based.
		
		You may assume that each input would have exactly one solution.

		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2
	
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] num, int target) {
		int[] indice = new int[2];
		
		int beg = 0, end = num.length-1;
		while(beg < end) {
			if(num[beg] + num[end] == target) {
				indice[0] = beg+1;
				indice[1] = end+1;
				break;
			} else if(num[beg] + num[end] > target)
				end--;
			else
				beg++;
		}
		return indice;
	}
}
