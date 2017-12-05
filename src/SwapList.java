
class ListNode {
	public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class SwapList {
	public ListNode swapPairs(ListNode A) {
        ListNode head = A;
        int temp;
        if(head==null){
            return null;
        }
        else if(head.next==null){
            return A;
        }
        while(head!=null && head.next!=null){
            temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;
            head = head.next.next;
        }
        return A;
    }
}
