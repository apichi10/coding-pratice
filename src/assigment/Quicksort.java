package assigment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Usage: 
 * 	quicksort(int[] arr, int lo, int hi, final int mode)
 * 	arr is the array to sort
 *  lo and hi are the begining and ending index of array
 *  
 *  mode=1:
 *  	quicksort pick the first element as pivot 
 *  mode=2
 *  	quicksort pick the last element as pivot
 *  else:
 *  	qiicksort uses median-of-three rule to pick pivot
 */

public class Quicksort {
	
	static int total = 0;
	
	public static void main(String[] args) {
		int arr[] = loadFromFile("src/assigment/QuickSort.txt");
		quicksort(arr, 0, arr.length-1, 1);
		System.out.println(total);
		total = 0;
		
		arr = loadFromFile("src/assigment/QuickSort.txt");
		quicksort(arr, 0, arr.length-1, 2);
		System.out.println(total);
		total = 0;
		
		arr = loadFromFile("src/assigment/QuickSort.txt");
		quicksort(arr, 0, arr.length-1, 3);
		System.out.println(total);
		total = 0;
	}
	
	public static void quicksort(int[] arr, int lo, int hi, final int mode){
		if (arr == null || arr.length == 0)
			return;
 
		if (lo >= hi)
			return;
		
		int pivot;
		switch(mode) {
			case 1:
				pivot = arr[lo];
				break;
			case 2:
				pivot = arr[hi];
				break;
			default:
				int mid = (hi + lo)/2;
				if(arr[hi]>arr[lo] && arr[hi]>arr[mid])
					pivot = arr[hi];
				else if(arr[lo]>arr[hi] && arr[lo]>arr[mid])
					pivot = arr[lo];
				else
					pivot = arr[mid];
				break;
		}
		
		int i=lo, j=hi;
		while(i<j) {
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if(i<hi) {
			quicksort(arr, i, hi, mode);
			total += (hi-i+1);
		}
		if(j>lo) {
			quicksort(arr, lo, j, mode);
			total += (j-lo+1);
		}
		
	}
	
	public static int[] loadFromFile(String filename) {
		ArrayList<Integer> list = new ArrayList<>();
		String line = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				list.add(Integer.valueOf(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		int[] arr = new int[list.size()];
		int idx = 0;
		for (int i : list)
			arr[idx++] = i;
		return arr;
	}
	
}
