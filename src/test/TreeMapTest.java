package test;

import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<>();
		tm.put(1, "a");
		tm.put(2, "b");
		//tm.put(3, "c");
		tm.put(4, "d");
		tm.put(5, "e");
		
		System.out.println(tm.higherEntry(5).getValue());
	}
}
