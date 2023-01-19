class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def mergeSort(head):
            if not head or not head.next : 
                return head
            
            left = slow = fast = head
            fast = fast.next
            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next
                
            right = slow.next
            slow.next = None
            
            left_sorted = mergeSort(left)
            right_sorted = mergeSort(right)
            return merge(left_sorted, right_sorted)
        
        def merge(l1, l2):
            dummy = ListNode(-1)
            prev = dummy
            while l1 and l2:
                if l1.val <= l2.val:
                    prev.next = l1
                    l1 = l1.next
                else:
                    prev.next = l2
                    l2 = l2.next            
                prev = prev.next
            prev.next = l1 or l2
            return dummy.next
        return mergeSort(head)
