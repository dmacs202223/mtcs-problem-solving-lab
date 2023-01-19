class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int> pq;
        int n = nums.size();
        if(n == 1)
            return nums[0];
        
        for(int i = 0;i < n;i++)
            pq.push(nums[i]);
        int c = 0;
        while(c < k-1){
            pq.pop();
            ++c;
            }
        return pq.top();
    }
};