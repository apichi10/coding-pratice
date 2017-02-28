package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {

	public static void main(String[] args) {
		System.out.println(numDecodings("2227"));
	}
	
	public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
    }
	
	public boolean isSubsequence(String s, String t) {
		char[] charArr = t.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<charArr.length; i++) {
        	if(!map.containsKey(charArr[i]))
        		map.put(charArr[i], new ArrayList<Integer>());
        	map.get(charArr[i]).add(i);
        }
		
        char[] arr = s.toCharArray();
        int prev=-1;
        for(int i=0; i<arr.length; i++) {
        	if(!map.containsKey(arr[i]))
        		return false;
        	for(int idx = 0; idx < map.get(arr[i]).size(); idx++) {
        		if(map.get(arr[i]).get(idx) > prev) {
        			prev = map.get(arr[i]).get(idx);
        			break;
        		}else if(idx == map.get(arr[i]).size()-1)
        			return false;
        	}
        }
		return true;
    }
	
}
