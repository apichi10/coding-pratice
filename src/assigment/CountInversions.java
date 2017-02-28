package assigment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountInversions {
	//static int arr[] = new int[100000];
	static int arr[] = new int[]{6,5,4,3,2,1};
	
	public static void main(String[] args) {
		//loadFromFile("src/assigment/IntegerArray.txt");
		System.out.println("Number of Inversions: " + countInversions(0, arr.length-1));
	}
	
	public static long merge(int begin, int end, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		long inversions = 0;
		int leftLen = leftEnd - leftStart + 1, rightLen = rightEnd-rightStart+1;
		int leftArr[] = new int[leftLen];
		int rightArr[] = new int[rightLen];
		
		System.arraycopy(arr, leftStart, leftArr, 0, leftLen);
		System.arraycopy(arr, rightStart, rightArr, 0, rightLen);
		
		int left = 0;
		int right = 0;
		
		int index = begin;
		while(index <= end) {
			if(left >= leftArr.length) {
				arr[index] = rightArr[right++];
			}else if(right >= rightArr.length) {
				arr[index] = leftArr[left++];
			}else if (leftArr[left] <= rightArr[right]) {
				arr[index] = leftArr[left++];
			}else if(leftArr[left] > rightArr[right]) {
				arr[index] = rightArr[right++];
				inversions = inversions + leftArr.length - left;
			}
			index++;
		}
		return inversions;
	}
	
	public static long countInversions(int begin, int end) {
		if(begin+1 == end) {
			if (arr[begin] > arr[end]) {
				int tmp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = tmp;
				return 1;
			} else {
				return 0;
			}
		}else if(begin == end) {
			return 0;
		}else {
			int leftStart = begin;
			int leftEnd = ((end-begin)/2) + begin;
			int rightStart = leftEnd+1;
			int rightEnd = end;
			long left = countInversions(leftStart, leftEnd);
			long right = countInversions(rightStart, rightEnd);
			long merge = merge(begin, end, leftStart, leftEnd, rightStart, rightEnd);
			
			return left + right + merge;
		}
	}
	
	public static void loadFromFile(String filename) {
		int counter = 0;
		String line = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((line = in.readLine()) != null) {
				arr[counter++] = Integer.valueOf(line);
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
	}
}
