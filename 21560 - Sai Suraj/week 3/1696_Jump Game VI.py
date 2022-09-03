class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dq = deque([0])
        for i in range(1, n):
            nums[i] = nums[dq[0]] + nums[i]
            while dq and nums[dq[-1]] <= nums[i]:
            	dq.pop()
            dq.append(i)
            if i - dq[0] >= k: dq.popleft()
        return nums[n - 1]
