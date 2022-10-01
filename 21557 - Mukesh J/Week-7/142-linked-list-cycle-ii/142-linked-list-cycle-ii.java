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
    public ListNode detectCycle(ListNode head) {
        ListNode temp= head,temp1=head;
        while(temp1!=null && temp1.next!=null)
        {
            temp=temp.next;
            temp1= temp1.next.next;
            if(temp==temp1)
                break;
        }
        if(temp1==null || temp1.next==null)
            return null;
        while(head!=temp)
        {
            head=head.next;
            temp=temp.next;
        }
        return head;
    }
}