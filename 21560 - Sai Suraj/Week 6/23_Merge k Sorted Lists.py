class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minh = []
        for i in range(len(lists)):
            if lists[i]:
                heappush(minh,[lists[i].val,i])
                lists[i] = lists[i].next
        
        curr = p =ListNode()
        while(minh):
            val,idx = heappop(minh)
            p.next = ListNode(val)
            p = p.next
            if lists[idx]:
                heappush(minh,[lists[idx].val,idx])
                lists[idx] = lists[idx].next
        return curr.nextclass Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minh = []
        for i in range(len(lists)):
            if lists[i]:
                heappush(minh,[lists[i].val,i])
                lists[i] = lists[i].next
        
        curr = p =ListNode()
        while(minh):
            val,idx = heappop(minh)
            p.next = ListNode(val)
            p = p.next
            if lists[idx]:
                heappush(minh,[lists[idx].val,idx])
                lists[idx] = lists[idx].next
        return curr.next
