class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        if(n == 1){
            return nums[0];
        }
        int max_so_far = nums[0], max_ending_here = nums[0],min_ending_here = nums[0];
        for(int i = 1;i < n;i++){
            int temp = max({nums[i],nums[i]*max_ending_here,nums[i]*min_ending_here});
            min_ending_here = min({nums[i],nums[i]*max_ending_here,nums[i]*min_ending_here});
            max_ending_here = temp;
            max_so_far = max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }
};