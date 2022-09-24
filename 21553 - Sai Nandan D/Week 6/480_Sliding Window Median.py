# Approach 1: Two heaps
from heapq import heappush, heappop, heappushpop
from collections import defaultdict

class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        lo, hi = [], []
        to_remove = defaultdict(int)
        medians = []        
        
        for i in range(k):
            heappush(lo, -heappushpop(hi, nums[i]))
            if len(hi) < len(lo):
                heappush(hi, -heappop(lo))
            
        if k % 2:
            medians.append(float(hi[0]))                
        else:
            medians.append((hi[0] - lo[0]) / 2.0)
                
        for i in range(k, len(nums)):                        
            heappush(lo, -heappushpop(hi, nums[i]))
            
            out = nums[i-k]            
            if out > -lo[0]: heappush(hi, -heappop(lo))
            to_remove[out] += 1
                
            while lo and to_remove[-lo[0]]:
                to_remove[-lo[0]] -= 1
                heappop(lo)
                
            while hi and to_remove[hi[0]]:
                to_remove[hi[0]] -= 1
                heappop(hi)
            
            if k & 1:
                medians.append(float(hi[0]))
            else:            
                medians.append((hi[0] - lo[0]) / 2.0)
            
        return medians
      

# Approach 2: Insort
class Solution:
  def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
      window = sorted(nums[:k])
      medians = []
      for i in range(k, len(nums)):
          medians.append((window[k//2] + window[~k//2]) / 2.0)
          window.remove(nums[i-k])
          bisect.insort(window, nums[i])        
      medians.append((window[k//2] + window[~k//2]) / 2.0)
      return medians
