class Solution:
    def calculate_median(self,maxheap,minheap):
        if len(minheap)==len(maxheap):
            return (minheap[0]-maxheap[0])/2.0
        return minheap[0]
    
    def insert(self,maxheap,minheap,num):
        heappush(maxheap,-heappushpop(minheap,num))
        
        if len(maxheap)>len(minheap):
            heappush(minheap,-heappop(maxheap))
    
    def remove(self,heap,num):
        pos = heap.index(num)
        heap[pos] = heap[-1]
        del heap[-1]
        if pos < len(heap):
            heapq._siftup(heap, pos)
            heapq._siftdown(heap,0,pos)
            # heapify(heap)
        
    def removeheaps(self,maxheap,minheap,num):
        if minheap[0]<=num:
            self.remove(minheap,num)
            return
        self.remove(maxheap,-num)
    
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        min_heap = []
        max_heap=[]
        res=[]
        for i in range(k-1):
            self.insert(max_heap,min_heap,nums[i])
            
        for i in range(k-1,len(nums)):
            self.insert(max_heap,min_heap,nums[i])
            median = self.calculate_median(max_heap, min_heap)
            res.append(median)
            self.removeheaps(max_heap,min_heap,nums[i-k+1])
        return res
