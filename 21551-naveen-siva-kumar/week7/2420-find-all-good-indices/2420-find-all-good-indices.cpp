class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        int N = nums.size();
        vector<int> decreasing(N, 1), increasing(N, 1);
        vector<int> ans;
        
        for(int i=1;i<N;i++){
            if(nums[i]<=nums[i-1]){
                decreasing[i] = decreasing[i-1]+1;
            }
        }
        for(int i = N-2;i>-1;i--){
            if(nums[i]<=nums[i+1]){
                increasing[i] = increasing[i+1]+1;
            }
        }
        
        for(int i=k;i<N-k;i++){
            if(decreasing[i-1]>=k && increasing[i+1]>=k ){
                ans.push_back(i);
            }
        }
        return ans;
    }
};