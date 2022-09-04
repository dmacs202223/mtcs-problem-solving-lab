class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int n = nums.size();
        if(n == 1)
            return nums[0];
        
        int arr_sum =0;
        for(int i = 0;i < n;i++)
            arr_sum += nums[i];
        
        int curr_max = nums[0], max_so_far = nums[0];
        int curr_min = nums[0], min_so_far = nums[0];
        
        for(int j = 1;j < n;j++){
            curr_max = max(curr_max + nums[j], nums[j]);
            max_so_far = max(curr_max, max_so_far);
            
            curr_min = min(curr_min + nums[j], nums[j]);
            min_so_far = min(curr_min, min_so_far);
        }
        
        if(min_so_far == arr_sum)
            return max_so_far;
        
        return max(max_so_far, arr_sum - min_so_far );
        
    }
};