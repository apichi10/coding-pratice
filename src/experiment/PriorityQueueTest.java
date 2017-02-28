package experiment;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(2);
		pq.add(4);
		pq.add(1);

		System.out.println(pq.poll());
	}

}
