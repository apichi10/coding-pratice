package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class KFrequent {
	public static void main(String[] args) {
		int[] nums = {4,4,4,4,1,1,1,1,2,2,3,3};
		int k = 1;
		
		Map<Integer, Integer> occurrence = new HashMap<>();
		for(int num : nums) {
			if(occurrence.containsKey(num))
				occurrence.put(num, occurrence.get(num)+1);
			else
				occurrence.put(num, 1);
		}
		
		
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>(){
			public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});
		pq.addAll(occurrence.entrySet());
		Iterator<Entry<Integer, Integer>> iter2 = pq.iterator();
		List<Integer> result = new ArrayList<>();
		while(iter2.hasNext()) {
			Entry<Integer, Integer> e = iter2.next();
			if(k==0 && !result.isEmpty() && occurrence.get(result.get(result.size()-1)) != e.getValue()) {
				break;
			}
			result.add(e.getKey());
			k--;
		}
		
		/*
		Collections.reverseOrder();
		Map<Integer, List<Integer>> m = new TreeMap<>(new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		Iterator<Entry<Integer, Integer>> iter = occurrence.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, Integer> e = iter.next();
			if(!m.containsKey(e.getValue()))
				m.put(e.getValue(), new ArrayList<Integer>());
			m.get(e.getValue()).add(e.getKey());
		}
		Iterator<Entry<Integer, List<Integer>>> iter2 = m.entrySet().iterator();
		List<Integer> result = new ArrayList<>();
		while(iter2.hasNext() && k > 0) {
			Entry<Integer, List<Integer>> e = iter2.next();
			result.addAll(m.get(e.getKey()));
			k -= m.get(e.getKey()).size();
		}
		*/
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
