package test;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {

	public static void main(String[] args) {
		int[] arr = new int[]{6,1,3,5,4,2};
		int k = 2;
		Arrays.sort(arr);
		System.out.println(arr[arr.length-k]);
		
		//int i = select(arr, 0, arr.length-1, 1);
		//System.out.println(i);
	}
	
	public static int select(int[] arr, int first, int last, int k) {
		
		if(first <= last) {
			int pivot = partition(arr, first, last);
			if(pivot == k-1)
				return arr[pivot];
			else if(pivot > k-1)
				return select(arr, first, pivot-1, k);
			else if(pivot < k-1)
				return select(arr, pivot+1, last, k);
		}
		return -1;
	}
	
	public static int partition(int[] arr, int first, int last) {
		Random ran = new Random();
		int pivot = first + ran.nextInt(last - first + 1);
		swap(arr, pivot, last);
		for(int i = first; i < last; i++) {
			if(arr[i] > arr[last]) {
				swap(arr, i, first);
				first++;
			}
		}
		swap(arr, first, last);
		return first;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
}
