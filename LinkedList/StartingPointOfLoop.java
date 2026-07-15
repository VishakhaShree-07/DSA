public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        
        if(slow==fast){
            ListNode pointer1 = head;
            ListNode pointer2 = slow;
            while(pointer1!=pointer2){
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            return pointer1;
            }
        }
        return null;
    }
}