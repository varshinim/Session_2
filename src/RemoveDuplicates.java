
public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        ListNode next_next;
        if(A==null){
            return null;
        }
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                next_next = curr.next.next;
                curr.next = null;
                curr.next = next_next;
            }
            else{
                curr = curr.next;
            }
        }
        return A;
    }
}
