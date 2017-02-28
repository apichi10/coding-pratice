package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParser {

	public static void main(String[] args) {
		NestedInteger n = deserialize("324");
		System.out.println(n.printNi(n, new StringBuilder()));
		
	}
	
	public static NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0)
        	return null;
        Stack<NestedInteger> stack = new Stack<>();
    	for(int i=0; i < s.length(); i++) {
    		if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
    			int start = i;
    			while(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')
    				i++;
    			if(stack.isEmpty())
    				stack.push(new NestedInteger(Integer.valueOf(s.substring(start, i+1))));
    			else
    				stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(start, i+1))));
    		} else if(s.charAt(i) == '[') {
    			stack.push(new NestedInteger());
    		} else if(s.charAt(i) == ']') {
    			stack.pop();
    		}
    	}
    	return stack.peek();
    }
}

class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;
    
    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }
    
    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
    
    public String printNi(NestedInteger thisNi, StringBuilder sb){
        if(thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for(NestedInteger ni : thisNi.list){
            if(ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            }
            else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}