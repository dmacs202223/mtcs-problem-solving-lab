class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        minh = []
        for i in nums:
            heappush(minh,i)
            if len(minh)>k:
                heappop(minh)
        return minh[0]
