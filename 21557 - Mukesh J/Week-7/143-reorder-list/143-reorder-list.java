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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack= new Stack<ListNode>();
        ListNode slow=head, fast=head,p=null,prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        if(fast!=null && fast.next==null)
        {   prev=slow; 
            slow= slow.next;
        }
        prev.next=null;
        while(slow!=null)
        {
            stack.push(slow);
            prev = slow;
            slow= slow.next;
            prev.next=null;
        }
        slow =head;
        while(slow!=null && !stack.isEmpty())
        {
            p = stack.pop();
            //System.out.println(p.val);
            p.next=slow.next;
            slow.next=p;
            slow =slow.next.next;;
        }
    }
}