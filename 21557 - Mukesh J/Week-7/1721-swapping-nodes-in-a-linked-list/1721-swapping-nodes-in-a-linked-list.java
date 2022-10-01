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
    public ListNode swapNodes(ListNode head, int k)
    {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy,temp1=dummy;
        
        for(int i=1;i<k;i++)
            temp1=temp1.next;
        ListNode leftparentnode= temp1;
        
        while(temp1.next.next!=null)
        {
            temp= temp.next;
            temp1=temp1.next;
        }
        ListNode rightparentnode=temp;
        
        ListNode left=leftparentnode.next;
        ListNode right=rightparentnode.next;
        
        leftparentnode.next=right;
        rightparentnode.next=left;
        
        ListNode swap= right.next;
        right.next=left.next;
        left.next=swap;
        return dummy.next;
    }
}