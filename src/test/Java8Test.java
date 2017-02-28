package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java8Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach((i)-> System.out.println(i) );
		Comparator<String> c = (str1, str2) ->  str2.length() - str1.length(); 
		System.out.println(c.compare("a", "bc"));
	}

}
