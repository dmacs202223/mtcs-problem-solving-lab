/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode slow= dummy, fast=head;
        slow.next=fast;
        while(fast!=null)
        {
            while(fast.next!=null && fast.val==fast.next.val)
                fast=fast.next;
            if(slow.next!=fast)
            {
                slow.next=fast.next;
                fast=slow.next;
            }
            else
            {
                fast= fast.next;
                slow= slow.next;
            }
        }
        return dummy.next;
    }
}