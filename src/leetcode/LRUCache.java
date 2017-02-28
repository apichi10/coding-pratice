package leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
	public static void main(String[] args) {
		//2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)]
		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		System.out.println(cache.get(1));
		cache.set(1, 5);
		cache.set(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
    int capacity;
    Map<Integer, Node> map;
    Node head;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
            return map.get(key).value;
        return -1;
        //return map.containsKey(key) ? map.get(key).value : -1;
    }
    
    public void set(int key, int value) {
        if(map.size() >= capacity && !map.containsKey(key)) {
            Node n = head.next;
            while(n.next != null)
                n = n.next;
            n.prev.next = null;
            map.remove(n.key);
        }
        if(map.containsKey(key)) {
            Node p = map.get(key);
            if(p.prev != head) {
            	p.prev.next = p.next;
            	if(p.next != null)
            		p.next.prev = p.prev;
            	head.next.prev = p;
            	p.prev = head;
            	p.next = head.next;
            	head.next = p;
            }
            p.value = value;
        } else {
            Node n = new Node(key, value);
            if(head.next != null)
                head.next.prev = n;
            n.next = head.next;
            n.prev = head;
            head.next = n;
            map.put(key, n);
        }
    }
    
    class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
}
