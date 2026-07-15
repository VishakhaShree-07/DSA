class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        head.next = flattenLinkedList(head.next);
        
        head = mergeTwoLists(head, head.next);
        
        return head;
    }
    
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.child = a;
                temp = temp.child;
                a = a.child;
            } else {
                temp.child = b;
                temp = temp.child;
                b = b.child;
            }
            temp.next = null; 
        }
        
        if (a != null) {
            temp.child = a;
        } else {
            temp.child = b;
        }
        
        return res.child;
    }
}