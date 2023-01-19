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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp= head,temp1=null;
        int count=0, count1=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        if(count==0 || k==0 || count==k)
            return head;
        if(k>count)
            k= k%count;
        count=count-k;
        temp=head;
        while(temp!=null)
        {
            count1++;
            if(count1==count)
            {
                temp1= temp.next;
                temp.next=null;
                temp=temp1;
            }
            else if(temp.next==null)
            {
                temp.next=head;
                head=temp1;
                break;
            }
            else
                temp=temp.next;
        }
        return head;
    }
}