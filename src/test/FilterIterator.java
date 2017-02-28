package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class FilterArrayList<E> extends ArrayList<E> {

	public Iterator<E> filterIterator(Filter<E> f) {
		return new FilterIterator<E>(this.iterator(), f);
	}
}

interface Filter<E> {
	public boolean match(E e);
}

class IntFilter<E> implements Filter<E> {

	@Override
	public boolean match(E e) {
		return ((Integer)e) % 10 == 0;
	}
	
}

public class FilterIterator<E> implements Iterator<E>{
	
	Iterator<E> iter;
	Filter<E> filter;
	boolean isNextAvailable;
	E nextElement;
	
	public FilterIterator(Iterator<E> iter, Filter<E> filter) {
		this.iter = iter;
		this.filter = filter;
		nextMatch();
	}
	
	@Override
	public boolean hasNext() {
		return isNextAvailable;
	}

	@Override
	public E next() {
		if(isNextAvailable) {
			E tmp = nextElement;
			nextMatch();
			return tmp;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public void nextMatch() {
		isNextAvailable = false;
		nextElement = null;
		while(iter.hasNext()) {
			E next = iter.next();
			if(filter.match(next)) {
				isNextAvailable = true;
				nextElement = next;
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		FilterArrayList<Integer> list = new FilterArrayList<>();
		list.add(40);
		list.add(2);
		list.add(50);
		Iterator<Integer> fiter = list.filterIterator(new IntFilter());
		while(fiter.hasNext()) {
			System.out.println(fiter.next());
		}
	}

}

