package test;

class ListNode {
	int val;
 	ListNode next;
 	ListNode(int x) { val = x; }
 	ListNode(int x, ListNode n) { val = x; next = n; }
}


public class PartitionList {

	public static void main(String[] args) {
		PartitionList p = new PartitionList();
		ListNode head = new ListNode(4, new ListNode(3, new ListNode(7, new ListNode(1, new ListNode(2)))));
		ListNode result = p.partition(head, 3);
		ListNode cur = result;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
        	return head;

        ListNode less = new ListNode(0);
        ListNode gte = new ListNode(0);
        ListNode lessTail = less, gteTail = gte, cur = head;

        while(cur != null) {
        	if(cur.val >= x) {
        		gteTail.next = cur;
        		gteTail = gteTail.next;
        	} else {
        		lessTail.next = cur;
        		lessTail = lessTail.next;
        	}
        	cur = cur.next;
        }
        
        gteTail.next = null;
        lessTail.next = gte.next;
        
        return less.next;
    }
}


/*
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
        	return head;

        ListNode less = null;
        ListNode gte = null;
        ListNode lessTail = null, gteTail = null, cur = head;

        while(cur != null) {
        	if(cur.val >= x) {
        		if(gte == null) {
        			gte = cur;
        			gteTail = cur;
        		} else {
        			gteTail.next = cur;
        			gteTail = gteTail.next;
        		}
        	} else {
        		if(less == null) {
        			less = cur;
        			lessTail = cur;
        		} else {
        			lessTail.next = cur;
        			lessTail = lessTail.next;
        		}
        	}
        	cur = cur.next;
        }
        if(less == null) {
        	head = gte;
        	gteTail.next = null;
        } else {
        	lessTail.next = gte;
        	if(gteTail != null)
        	gteTail.next = null;
        	head = less;
        }
        return head;
    }
    */
