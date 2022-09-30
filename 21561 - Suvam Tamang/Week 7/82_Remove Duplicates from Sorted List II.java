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
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            while(curr != null && curr.next != null && curr.val == curr.next.val)
               curr = curr.next;
            if(temp.next == curr)
                temp = curr;
            else
                temp.next = curr.next;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
