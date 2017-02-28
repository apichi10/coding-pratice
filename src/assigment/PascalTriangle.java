package assigment;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	
	public List<Integer> generate(int depth) {
        List<Integer> result = new ArrayList<>();
        if(depth == 0) {
        	result.add(1);
            return result;
        }
        	
        List<Integer> prev = generate(depth-1);
        for(int j = 0; j <= prev.size(); j++) {
        	if(j==0 || j==prev.size())
        		result.add(1);
        	else
        		result.add( prev.get(j-1) + prev.get(j) );
        }
        return result;
    }
	
	public void pascalTriangle(int depth) {
		for(int i=0; i<depth; i++) {
			List<Integer> level = generate(i);
			for (Integer integer : level) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		pt.pascalTriangle(7);
	}
}
