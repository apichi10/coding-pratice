package leetcode;

// Count the “1” bits in an integer
// 12 = 1100 => 2 
public class CountOneBit {
	
	public static int count(int intToCount) {
		int counter = 0;
		while(intToCount != 0) {
			counter += intToCount & 1;
			intToCount >>>= 1;
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println(count(698));
	}
}
