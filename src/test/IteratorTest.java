package test;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Iterator<Integer> iter = list.iterator();
		iter.next();
		iter.next();
		iter.next();
		System.out.println(iter.next());
		Iterator<Integer> iter2 = list.iterator();
		System.out.println(iter2.next());
		iter.remove();
		System.out.println(iter2.next());
		
	}
}
