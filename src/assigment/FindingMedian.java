package assigment;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * FindingMedian uses two PriorityQueue(heap) to track the median.  
 * The Min-heap stores all the numbers greater than median, and Max-heap stores all the numbers less than median. 
 * If one of the heaps have more than one elements than the other, the top element moves to the other heap. 
 * Repeat this step until the two heaps are balanced. 
 * 
 * FindingMedian takes an array of integer to construct. The time complexity to create FindingMedian is O(NlogN).
 * After FindingMedian is created, the time complexity for insertion is O(logN) per element.
 * 
 * Usage:
 * 
 * Create FindingMedian:
 * FindingMedian fm = new FindingMedian(new int[]{1,2,3});
 * 
 * Insert element:
 * fm.insert(4);
 * 
 * Insert two or more elements at a time:
 * fm.insert(10,8,4,30,2);
 * 
 * Get median:
 * fm.getMedian();
 * 
 */


public class FindingMedian {
	
	private PriorityQueue<Integer> min, max;
	
	public static void main(String[] args) {
		FindingMedian fm = new FindingMedian(new int[]{1,2,3});
		fm.insert(4);
		fm.insert(10,8,4,30,2);
		System.out.println(fm.getMedian());
	}
	
	public FindingMedian(int[] arr) {
		Arrays.sort(arr);
		min = new PriorityQueue<>();
		max = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i < arr.length; i++) {
			if(i < arr.length/2)
				max.offer(arr[i]);
			else
				min.offer(arr[i]);
		}
	}
	
	public float getMedian() {
		if(max.size() == 0 && min.size()==0)
			return 0;
		if(max.size() == min.size())
			return (float) ((max.peek() + min.peek())/2.0);
		else if(max.size() > min.size())
			return max.peek();
		else
			return min.peek();
			
	}
	
	public void insert(int num) {
		float median = getMedian();
		// decide which heap to go
		if(num >= median)
			min.offer(num);
		else
			max.offer(num);
		
		// balance two heap
		if(max.size()-min.size()>1)
			min.offer(max.poll());
		else if(min.size()-max.size()>1)
			max.offer(min.poll());
	}
	
	public void insert(int... nums) {
		for (int i : nums)
			insert(i);
	}
}
