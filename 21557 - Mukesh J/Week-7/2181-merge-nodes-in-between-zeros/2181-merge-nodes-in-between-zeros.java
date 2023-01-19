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
    public ListNode mergeNodes(ListNode head) {
        ListNode slow=head, fast=head, prev=null;
        int sum=0;
        while(slow!=null)
        {
            fast=slow.next;
            while(fast!=null && fast.val!=0)
            {
                sum += fast.val;
                fast= fast.next;
            }
            if(fast==null)
            {
                prev.next=null;
                break;
            }
            slow.val=sum;
            sum=0;
            slow.next=fast;
            prev=slow;
            slow= slow.next;
        }
        return head;
    }
}