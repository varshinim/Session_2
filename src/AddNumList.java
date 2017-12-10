
public class AddNumList {
	public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode C = null;
		ListNode head = null;
		ListNode prev = null;
		int carry = 0;
		int sum = 0;
		if(A==null && B==null){
			return null;
		}
		while(A!=null || B!=null){
			if(A==null){
				sum = carry+B.val;
			}
			else if(B==null){
				sum = carry+A.val;
			}
			else{
				sum = carry+A.val+B.val;
			}
			if(sum>=10){
				carry = 1;
				sum = sum%10;
			}
			else{
				carry = 0;
			}
			C = new ListNode(sum);
			if(head==null){
				head = C;
			}
			else{
				prev.next = C;
			}
			prev = C;
			if(A!=null){
				A = A.next;
			}
			if(B!=null){
				B = B.next;
			}
		}
		if(carry>0){
			C.next = new ListNode(carry);
		}
		return head; 
	}
}
