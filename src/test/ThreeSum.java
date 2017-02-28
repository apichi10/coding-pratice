package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> result = threeSum2(num);
		
		for(List<Integer> list : result) {
			System.out.print("[ ");
			for(int i: list) {
				System.out.print(i + " ");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}
	
	/*
	The idea is to sort an input array and then run through all 
	indices of a possible first element of a triplet. 
	For each possible first element we make a standard bi-directional 
	2Sum sweep of the remaining part of the array. Also we want to 
	skip equal elements to avoid duplicates in the answer without making 
	a set or smth like that.
	 
	 
	*/
	
	
	public static List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1])
	                    	lo++;
	                    while (lo < hi && num[hi] == num[hi-1])
	                    	hi--;
	                    lo++;
	                    hi--;
	                } else if(num[lo] + num[hi] < sum) 
	                	lo++;
	                else
	                	hi--;
	           }
	        }
	    }
	    return res;
	}
	
	public static List<List<Integer>> threeSum2(int[] num) {
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(num);
		Set<List<Integer>> set = new HashSet<>();
		
		for(int i = 0; i < num.length-2; i++) {
			int sum = num[i];
			int lo = i+1;
			int hi = num.length-1;
			while(lo < hi) {
				if(sum + num[lo] + num[hi] == 0) {
					List<Integer> l = Arrays.asList(num[i],num[lo],num[hi]);
					if(set.add(l))
						result.add(l);
					lo++;
					hi--;
				} else if(sum + num[lo] + num[hi] > 0) {
					hi--;
				} else
					lo++;
			}
		}
		return result;
	}
}
