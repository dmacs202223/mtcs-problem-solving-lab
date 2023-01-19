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
    public ListNode partition(ListNode head, int x) {
        ListNode leftdummy= new ListNode(0), rightdummy= new ListNode(0);
        ListNode slow=head, temp=rightdummy,temp1=leftdummy;
        while(slow!=null)
        {
            if(slow.val<x)
            {
                leftdummy.next=slow;
                leftdummy= leftdummy.next;
            }
            else
            {
                rightdummy.next=slow;
                rightdummy=rightdummy.next;
            }
            slow= slow.next;
        }
        leftdummy.next=temp.next;
        rightdummy.next=null;
        return temp1.next;
    }
}