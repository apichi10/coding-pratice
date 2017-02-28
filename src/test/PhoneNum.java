package test;

import java.util.ArrayList;
import java.util.List;

public class PhoneNum {
	
	final static String[] letter = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	public List<String> letterCombinations(String digit) {
		List<String> result = new ArrayList<String>();
		hrlper(digit, 0, new StringBuilder(), result);
		
		return result;
	}
	
	public void hrlper(String digit, int index, StringBuilder combination, List<String> result){
		if(index >= digit.length()) {
			result.add(combination.toString());
			return;
		}
		int num = Integer.parseInt(digit.substring(index, index+1));
		char[] carr = letter[num].toCharArray();
		
		for(int i=0; i<carr.length; i++) {
			combination.append(carr[i]);
			hrlper(digit, index+1, combination, result);
			combination.deleteCharAt(combination.length()-1);
		}
	}
	
	public static void main(String[] args) {
		PhoneNum p = new PhoneNum();
		List<String> result = p.letterCombinations("23");
		for(String s : result) {
			System.out.println(s);
		}
	}
}
