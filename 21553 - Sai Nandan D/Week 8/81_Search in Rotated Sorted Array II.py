class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        def dfs(l, r):
            if r - l <= 1:
                return target in nums[l:r+1]
            
            mid = (l+r) // 2
            if nums[mid] == target:
                return True
            
            if nums[mid] > nums[r]:
                if nums[r] < target < nums[mid]:
                    return dfs(l, mid-1)
                else:
                    return dfs(mid+1, r)
            
            elif nums[mid] < nums[r]:
                if nums[mid] < target <= nums[r]:
                    return dfs(mid+1, r)
                else:
                    return dfs(l, mid-1)
                    
            else: return dfs(l, mid-1) or dfs(mid+1, r)
            
        return dfs(0, len(nums)-1)
