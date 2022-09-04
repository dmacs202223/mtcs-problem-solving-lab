class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
       int n = nums.size();
        vector<int> left(n), right(n);
        int wind_size = n - k + 1;
        vector<int> output(wind_size);
        
        for(int i = 0;i < n;i++){
            left[i] = nums[i];
            if(i % k != 0)
                left[i] = max(left[i], left[i-1]);
            
        }
        
        right[n-1] = nums[n- 1];
        for(int j = n-2;j >= 0;j--){
            right[j] = nums[j];
            if(j % k != k - 1)
                right[j] = max(right[j], right[j+1]);
        }
        
        for(int i = 0;i < wind_size;i++){
            output[i] = max(right[i], left[i+k-1]);
        }
        return output;
    }
};