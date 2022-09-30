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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
 
        ListNode middle = middleNode(head);
        ListNode nextofmiddle = middle.next;
 
        middle.next = null;
 
        ListNode left = sortList(head);
 
        ListNode right = sortList(nextofmiddle);
 
        ListNode sortedlist = mergeTwoLists(left, right);
        return sortedlist;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode help = new ListNode(0);
        ListNode temp = help; 
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
                
        if(list1 != null) {
            temp.next = list1;
        }
        
        if(list2 != null) {
            temp.next = list2;
        }
        
        return help.next;
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
}
