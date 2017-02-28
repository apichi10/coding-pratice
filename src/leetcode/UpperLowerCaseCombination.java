package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UpperLowerCaseCombination {
	
	public static void main(String[] args) {
		UpperLowerCaseCombination o = new UpperLowerCaseCombination();
		o.generate(new String[]{"aaa","bbb","123"});
	}
	
	public void generate(String[] input) {
		
		List<List<String>> result = new ArrayList<>();
		helper(input, result, new ArrayList<>(), 0);
		for (List<String> list : result) {
			for (String string : list) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
		
	}
	
	public void helper(String[] input, List<List<String>> result, List<String> list, int index) {
		if(list.size() == input.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = index; i < input.length; i++) {
			if(hasChar(input[i])) {
				list.add(input[i].toUpperCase());
				helper(input, result, list, i+1);
				list.remove(list.size()-1);
				list.add(input[i].toLowerCase());
				helper(input, result, list, i+1);
				list.remove(list.size()-1);
			} else {
				list.add(input[i]);
				helper(input, result, list, i+1);
				list.remove(list.size()-1);
			}
		}
	}
	
	public boolean hasChar(String str) {
		return !str.toLowerCase().equals(str.toUpperCase());
	}
	
}
