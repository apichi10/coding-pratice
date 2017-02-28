package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<List<Integer>> set = new HashSet<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		set.add(list1);
		set.add(list2);
		System.out.println(set.size());

	}

}
