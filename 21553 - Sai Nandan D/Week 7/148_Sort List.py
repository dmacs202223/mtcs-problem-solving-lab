# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:        
        if not head or not head.next: return head
        slow, fast = head, head.next        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next       
        l = head
        r = slow.next
        slow.next = None
        return self.merge(self.sortList(l), self.sortList(r))
    
    
    def merge(self, h1, h2):
        head = tail = ListNode()
        while h1 and h2:
            if h1.val <= h2.val:
                tail.next = h1
                h1 = h1.next                    
            else:
                tail.next = h2
                h2 = h2.next                    
            tail = tail.next      
        tail.next = h1 or h2
        return head.next
