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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        temp=head;
        if(count==n)
            return temp.next;
        int count1=0;
        while(temp!=null)
        {
            count1++;
            if(count1+1== count-n+1)
            {
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
}