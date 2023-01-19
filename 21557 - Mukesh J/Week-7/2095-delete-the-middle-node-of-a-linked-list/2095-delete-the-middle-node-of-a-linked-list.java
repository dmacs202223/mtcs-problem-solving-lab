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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int count=0,count1=0;
        while(temp!=null)
        {
            count++;
            temp= temp.next;
        }
        if(count==1)
        {
            ListNode p= new ListNode();
            return p.next;
        }
        count= count/2;
        temp=head;
        while(temp!=null)
        {
            if(count1+1==count)
            {
                temp.next= temp.next.next;
                break;
            }
            temp=temp.next;
            count1++;
        }
        return head;
    }
}