/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head, fast=head;
        if(head==null)
            return false;
        while(fast!=null)
        {
            if(fast.next!=null && fast.next.next!=null)
            {
                fast= fast.next.next;
                slow= slow.next;
                if(fast==slow)
                    break;
            }
            else
                return false;
            
        }
        return true;
    }
}