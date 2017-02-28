package test;

import java.util.*;

public class Test {
	static int a = getValue();
	static int b = 10;
	
	static int getValue() {
		return b;
	}
	
	public static void main(String[] args) {
		String str = "sky is  blue";
		String[] arr = str.split(" ");
		for (String string : arr) {
			System.out.print(string);
		}
	}
	
	public void meth() {
		System.out.println("hahah");
	}
}


/*
public class NestedIterator implements Iterator<Integer> {
    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null; //Just in case
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) 
            	stack.pop();
            else {
            	nextInt = stack.peek().next();
            	if (nextInt.isInteger())
            		return true;
            	else
            		stack.push(nextInt.getList().iterator());
            }
        }
        return false;
    }
}
*/
