# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Approach 1: Priority Queue
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ = lambda self, other: self.val < other.val
        
        result_head = result_tail = ListNode()
        heap = []
        for list_head in lists:
            if list_head:
                heapq.heappush(heap, list_head)
                
        while heap:
            node = heapq.heappop(heap)
            result_tail.next = node
            result_tail = result_tail.next
            if node.next:
                heapq.heappush(heap, node.next)
                
        return result_head.next
        
 
 # Approach 2: Divide and Conquer
 
 # 2.1: Iterative merging
 class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def merge2lists(l1, l2):
            head = result = ListNode()
            while l1 and l2:
                if l1.val <= l2.val:
                    result.next = l1
                    l1 = l1.next
                else:
                    result.next = l2
                    l2 = l2.next                    
                result = result.next
            result.next = l1 or l2
            return head.next
        
        n = len(lists)
        step = 1        
        while step < n:
            for i in range(0, n-step, step*2):
                lists[i] = merge2lists(lists[i], lists[i+step])
            step *= 2
            
        return lists[0] if n > 0 else None
        
 # 2.2: Recursive merging
 class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def merge2lists(l1, l2):
            if l1 and l2:
                if l1.val > l2.val:
                    l1, l2 = l2, l1
                l1.next = merge2lists(l1.next, l2)
            return l1 or l2
            
        
        n = len(lists)
        step = 1        
        while step < n:
            for i in range(0, n-step, step*2):
                lists[i] = merge2lists(lists[i], lists[i+step])
            step *= 2
            
        return lists[0] if n > 0 else None
