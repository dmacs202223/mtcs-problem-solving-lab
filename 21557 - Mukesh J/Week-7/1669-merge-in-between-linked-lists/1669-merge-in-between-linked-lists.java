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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy= new ListNode(0),slow=dummy,p=null,q=null;
        slow.next=list1;
        int count=-1;
        while(slow.next!=null)
        {
            if(count==a-1)
            {
                p= slow.next;
                slow.next=list2;
                slow=slow.next;
                while(slow.next!=null)
                    slow=slow.next;
                q=slow;
                slow=p;
                count++;
            }
            if(count==b)
            {
                q.next=slow.next;
                break;
            }
            count++;
            slow=slow.next;
        }
        return list1;
    }
}