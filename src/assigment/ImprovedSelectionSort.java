package assigment;

import java.util.PriorityQueue;

/*
 * Using heap to improve selection sort. 
 * Selection sort iterate through the array over and over again to find the smallest element and move it to the right position.
 * By using heap, we can skip this step. On every iteration, we can get the smallest element from the heap in O(1) time.
 * However, creating the heap will take O(NlogN) time. Therefore the total time complexity is improved from O(N^2) to O(NlogN). 
 * 
 * Usage:
 * ImprovedSelectionSort.sort(arrayToBeSorted);
 * 
 */


public class ImprovedSelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[]{2,6,32,7,64,24,24,72,15};
		ImprovedSelectionSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	static void sort(int[] arr) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i : arr)
			heap.offer(i);
		int idx = 0;
		while(heap.size() > 0) {
			arr[idx++] = heap.poll();
		}
	}
}
