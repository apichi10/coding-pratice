package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
	Median is the middle value in an ordered integer list. 
	If the size of the list is even, there is no middle value. 
	So the median is the mean of the two middle value.
	
	Examples: 
	[2,3,4] , the median is 3
	
	[2,3], the median is (2 + 3) / 2 = 2.5
	
	Given an array nums, there is a sliding window of size k which is moving 
	from the very left of the array to the very right. You can only see the k numbers in the window. 
	Each time the sliding window moves right by one position. 
	
	Your job is to output the median array for each window in the original array.
	
	For example,
	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	
	Window position                Median
	---------------               -----
	[1  3  -1] -3  5  3  6  7       1
	 1 [3  -1  -3] 5  3  6  7       -1
	 1  3 [-1  -3  5] 3  6  7       -1
	 1  3  -1 [-3  5  3] 6  7       3
	 1  3  -1  -3 [5  3  6] 7       5
	 1  3  -1  -3  5 [3  6  7]      6
	Therefore, return the median sliding window as [1,-1,-1,3,5,6].
	

*/


/*
	Use two Heaps to store numbers. maxHeap for numbers smaller than current median, 
	minHeap for numbers bigger than and equal to current median. 
	
	A small trick I used is always make size of minHeap equal (when there are even numbers) or 
	1 element more (when there are odd numbers) than the size of maxHeap. 
	Then it will become very easy to calculate current median.
	
	Keep adding number from the right side of the sliding window and remove number from left side. 
	And keep adding current median to the result.
*/

public class SlidingWindowMedian {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    /*
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
    	public int compare(Integer o1, Integer o2) {
    		return o2.compareTo(o1);
    	};
	});
	*/
	
	
	public static void main(String[] args) {
		SlidingWindowMedian swm = new SlidingWindowMedian();
		double[] result = swm.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		for (double d : result) {
			System.out.println(d);
		}
	}
	
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0)
            return new double[0];
        double[] result = new double[n];
        
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
            	result[i - k] = getMedian();
            	remove(nums[i - k]);
            }
            if (i < nums.length) {
            	add(nums[i]);
            }
        }
        return result;
    }
    
    private void add(int num) {
    	if (num < getMedian()) {
    		maxHeap.add(num);
    	} else {
    		minHeap.add(num);
    	}
    	balanceHeap();
    }
	
    private void remove(int num) {
    	if (num < getMedian()) {
    		maxHeap.remove(num);
    	} else {
    		minHeap.remove(num);
    	}
    	balanceHeap();
    }
	
    private double getMedian() {
    	if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
	    
    	if (maxHeap.size() == minHeap.size()) {
    		return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
    	} else {
            return (double)minHeap.peek();
    	}
    }
    
    private void balanceHeap() {
    	if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.poll());
    	else if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
    }

}