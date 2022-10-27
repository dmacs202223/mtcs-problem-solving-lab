class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int low = 0, high = nums.length-1, mid, res1 = -1;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(nums[mid] == target)
            {
                res1 = mid;
                high = mid - 1; 
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        low = 0;
        high = nums.length - 1;
        int res2 = -1;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(nums[mid] == target)
            {
                res2 = mid;
                low = mid + 1; 
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return new int[]{res1 ,res2};
    }
}
