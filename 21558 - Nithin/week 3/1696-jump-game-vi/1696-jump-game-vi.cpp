class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> dp(n);
        dp[0] = nums[0];
        deque<int> queue{0};
        
        for(int i = 1; i < n; i++){
            if(queue.front() < i - k)
                queue.pop_front();
            dp[i] = nums[i] + dp[queue.front()];
            while(!queue.empty() && dp[queue.back()] <= dp[i])
                queue.pop_back();
            queue.push_back(i);
        }
         return dp.back();
    }
};