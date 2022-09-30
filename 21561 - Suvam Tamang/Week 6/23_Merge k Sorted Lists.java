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
    
//     A kind of a Brute Force Method! 
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists == null || lists.length == 0) {
//             return null;
//         }
//         for(int i=0; i<lists.length-1; i++) {
//             ListNode head = mergeTwoLists(lists[i], lists[i+1]);
//             lists[i+1] = head;
//         }
//         return lists[lists.length-1];
//     }
    
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         ListNode help = new ListNode(0);
//         ListNode temp = help; 
        
//         while(list1 != null && list2 != null) {
//             if(list1.val < list2.val) {
//                 temp.next = list1;
//                 list1 = list1.next;
//             } else {
//                 temp.next = list2;
//                 list2 = list2.next;
//             }
//             temp = temp.next;
//         }
                
//         if(list1 != null) {
//             temp.next = list1;
//         }
        
//         if(list2 != null) {
//             temp.next = list2;
//         }
        
//         return help.next;
//     }
    
// Let's solve the same question using Priority Queue or Min-Heap to be specific in this case
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
           @Override
           public int compare(ListNode node1, ListNode node2) {
               if(node1.val < node2.val)
                   return -1;
               if(node1.val > node2.val)
                   return 1;
               return 0;
           }
        });
        
        for(ListNode listNodes : lists) {
            if(listNodes != null)
                pq.add(listNodes);
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while(!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            
            if(tail.next != null)
                pq.add(tail.next);
        }
        return head.next;
    }
}
