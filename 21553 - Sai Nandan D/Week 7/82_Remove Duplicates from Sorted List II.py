# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre = dummy = ListNode(0, head)
        while head and head.next:
            if head.val != head.next.val:
                head = head.next
                pre = pre.next
            else:
                while head and head.next and head.val == head.next.val:
                    head = head.next
                pre.next = head.next
                head = head.next
                
        return dummy.next
