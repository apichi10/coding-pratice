package leetcode;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		List<Interval> intervals = new ArrayList<Interval>();
		//[[0,2],[1,4],[3,5]]
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(3, 5));
		List<Interval> result = mi.merge(intervals);
		
		System.out.print("[");
		for (Interval interval : result)
			System.out.print(interval);
		System.out.print("]");
	}
	
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(int i=1; i < intervals.size(); i++) {
        	if(start<0 || end<0) {
        		start = intervals.get(i).start;
        		end = intervals.get(i).end;
        	} else if(end >= intervals.get(i).start)
        		end = Math.max(end, intervals.get(i).end);
        	else {
        		result.add(new Interval(start, end));
        		start = -1;
        		end = -1;
        	}
        }
        if(start>0 || end>0)
        	result.add(new Interval(start, end));
        return result;
    }
    
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	@Override
	public String toString() {
		return "["+ start + "," + end  +"]";
	}
}
