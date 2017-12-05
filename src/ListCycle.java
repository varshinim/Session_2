
public class ListCycle {
	public ListNode detectCycle(ListNode a) {
	    ListNode slow = a;
	    ListNode fast = a;
	    ListNode slow2 = a;
	    while(fast!=null && fast.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow == fast){
	            slow2 = a;
	            while(slow2!=slow){
	                slow = slow.next;
	                slow2 = slow2.next;
	            }
	            return slow;
	        }
	    }
	    return null;
	}
}
