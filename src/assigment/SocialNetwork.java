package assigment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Jing-Wu Chen
 * 167177
 * 
 */


public class SocialNetwork {
	
	Map<String, Person> nameToPerson;
	List<String> edges;
	
	public SocialNetwork(String[] names) {
		nameToPerson = new HashMap<>();
		edges = new ArrayList<>();
		for (String name : names) {
			Person p = new Person(name);
			nameToPerson.put(name, p);
		}
	}
	
	public static void main(String[] args) {
		
		// Create an initial network of many people:
		SocialNetwork sn = new SocialNetwork(new String[]{"Alice","John","Sally","Tom","Alex","Chris"});
		//Add relationships: 
		sn.addFriend("Alice", "John");
		sn.addFriend("Sally", "John");
		sn.addFriend("Sally", "Alex");
		sn.addFriend("Tom", "John");
		sn.addFriend("Tom", "Sally");
		sn.addFriend("Alice", "Chris");
		
		
		//  Print all the edges in the network:
		System.out.println("Edges in the network: ");
		sn.printNetwork();
		
		// Show path between those two people: 
		System.out.println("\nPath between Chris and Sally:");
		System.out.println(sn.showRelationship("Chris", "Sally"));
		System.out.println("\nPath between Chris and Alex:");
		System.out.println(sn.showRelationship("Chris", "Alex"));
		System.out.println("\nPath between Tom and Alice:");
		System.out.println(sn.showRelationship("Tom", "Alice"));
		System.out.println("\nPath between Alex and Alice:");
		System.out.println(sn.showRelationship("Alex", "Alice"));
		
		// Show friends n steps away:
		System.out.println("\nFriends 2 steps away from John");
		for (String name : sn.showHops("John", 2)) {
			System.out.println(name);
		}
		
		System.out.println("\nFriends 3 steps away from Tom");
		for (String name : sn.showHops("Tom", 3)) {
			System.out.println(name);
		}
	}
	
	public void printNetwork() {
		for (String edge : edges) {
			System.out.println(edge);
		}
	}
	
	public void addFriend(String name1, String name2) {
		Person p1 = nameToPerson.get(name1);
		Person p2 = nameToPerson.get(name2);
		p1.addFriend(p2);
		p2.addFriend(p1);
		edges.add(name1 + "<=>" + name2);
	}
	
	public String showRelationship(String p1, String p2) {
		return this.showRelationship(this.nameToPerson.get(p1), this.nameToPerson.get(p2));
	}
	
	public String showRelationship(Person p1, Person p2) {
		if(p1 == p2)
			return p1.getName();
		Set<Person> visited = new HashSet<>();
		Map<Person, Person> prev = new HashMap<>();
		Queue<Person> bst = new LinkedList<>();
		bst.offer(p1);
		visited.add(p1);
		while(!bst.isEmpty()) {
			Person cur = bst.poll();
			for (Person person : cur.friends) {
				if(visited.contains(person))
					continue;
				bst.offer(person);
				visited.add(person);
				prev.put(person, cur);
				if(person == p2)
					break;
			}
			if(prev.containsKey(p2))
				break;
		}
		if(!prev.containsKey(p2))
			return null;
		
		Person p = p2;
		StringBuilder sb = new StringBuilder();
		sb.append(p.getName());
		while(p!=p1) {
			p = prev.get(p);
			sb.insert(0, p.getName() + "->");
		}
		
		return sb.toString();
	}
	
	public List<String> showHops(String p, int hops) {
		return this.showHops(this.nameToPerson.get(p), hops);
	}
	
	public List<String> showHops(Person p, int hops) {
		Set<Person> visited = new HashSet<>();
		List<String> list = new ArrayList<>();
		Queue<Person> bst = new LinkedList<>();
		
		if(hops==0) {
			list.add(p.getName());
			return list;
		}
		
		bst.offer(p);
		bst.offer(null);
		visited.add(p);
		while(!bst.isEmpty() && hops > 0) {
			if(bst.peek()==null) {
				hops--;
				bst.offer(null);
				bst.poll();
			}
			Person cur = bst.poll();
			if(cur == null)
				return list;
			for (Person person : cur.friends) {
				if(visited.contains(person))
					continue;
				if(hops==1)
					list.add(person.getName());
				bst.offer(person);
				visited.add(person);
			}
		}
		
		return list;
	}
}

class Person {
	String name;
	public Set<Person> friends;
	
	public Person(String name) {
		this.name = name;
		friends = new HashSet<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addFriend(Person person) {
		friends.add(person);
	}
	
	public void removeFriend(Person person) {
		friends.remove(person);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
