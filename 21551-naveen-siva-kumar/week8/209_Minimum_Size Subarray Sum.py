class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int ans = INT_MAX;
        int windowS=0,windowE=0;
        int windowSize=0;
        int windowSum =0;
        for(int i=0;i<nums.size();i++){
            
            windowSum += nums[i];
            windowE++;
            
            while(windowSum>=target){
                ans = min(ans,windowE-windowS);
                windowSum -= nums[windowS];
                windowS++;
            }
        }
        return ans==INT_MAX?0:ans;
    }
};
