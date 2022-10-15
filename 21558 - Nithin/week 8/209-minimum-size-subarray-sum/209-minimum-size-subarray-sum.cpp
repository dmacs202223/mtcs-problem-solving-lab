class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        int min_len = INT_MAX;
        int sum = 0;
        int i,j = 0;

        for(i = 0;i <n;i++){
              sum += nums[i];
             
              while(sum >= target)
              {
                  min_len = min(min_len,(i+1)-j);
                  sum -= nums[j];
                  ++j;
              }
        }
        
        if(min_len == INT_MAX)
            return 0;
        
        return min_len;
    }
};