package experiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Autocomplete {
	
	Trie root;
	HashMap<Character, List<Trie>> dict = new HashMap<>();
	
	public Autocomplete() {
		root = new Trie();
	}
	
	public static void main(String[] args) {
		Autocomplete ac = new Autocomplete();
		ac.addWord("jim");
		ac.addWord("jimmy");
		ac.addWord("james");
		ac.addWord("michael");
		ac.addWord("chael");
		ac.addWord("im");
		ac.addWord("imim");
		
		Set<Trie> result = ac.searchWord("im");
		Set<String> strs = ac.getAllWords(result);
		for (String string : strs) {
			System.out.println(string);
		}
		
	}
	
	public void addWord(String word) {
		char[] arr = word.toCharArray();
		Trie cur = root;
		for(int i=0; i < arr.length; i++) {
			int index = arr[i] - 'a';
			if(cur.children[index] != null) {
				cur = cur.children[index];
			} else {
				cur.children[index] = new Trie();
				cur.children[index].character = arr[i];
				if(dict.containsKey(arr[i])){
					dict.get(arr[i]).add(cur.children[index]);
				} else {
					List<Trie> list = new ArrayList<>();
					list.add(cur.children[index]);
					dict.put(arr[i], list);
				}
				cur = cur.children[index];
			}
			if(i == arr.length-1)
				cur.word = word;
		}
	}
	
	public Set<Trie> searchWord(String word) {
		char[] query = word.toCharArray();
		Set<Trie> set = new HashSet<>();
		set.addAll(dict.get(query[0]));
		Set<Trie> result = new HashSet<>();
		Iterator<Trie> iter = set.iterator();
		while (iter.hasNext()) {
			Trie cur = iter.next();
			for(int i=1; i<word.length(); i++) {
				int index = query[i] - 'a';
				if(cur.children[index]==null) {
					iter.remove();
					break;
				} else {
					cur = cur.children[index];
				}
				if(i==word.length()-1)
					result.add(cur);
			}
		}
		return result;
	}
	
	public Set<String> getAllWords(Set<Trie> tries) {
		Set<String> result = new HashSet<>();
		Stack<Trie> stack = new Stack<>();
		stack.addAll(tries);
		while(!stack.isEmpty()) {
			Trie cur = stack.pop();
			if(cur.word != null)
				result.add(cur.word);
			for (Trie trie : cur.children) {
				if(trie != null)
					stack.push(trie);
			}
		}
		return result;
	}

}

class Trie {
	char character;
	Trie[] children;
	String word;
	
	public Trie() {
		children = new Trie[26];
		this.word = null;
	}
	
	public Trie(char character) {
		this.character = character;
		children = new Trie[26];
		this.word = null;
	}
	
	public Trie(char character, String word) {
		this.character = character;
		children = new Trie[26];
		this.word = word;
	}
}