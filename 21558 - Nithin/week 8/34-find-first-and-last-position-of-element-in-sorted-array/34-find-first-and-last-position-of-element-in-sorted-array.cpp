class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int len = nums.size();
        int left = 0, right = len -1;
        int mid, res = -1;
        vector<int> pos;
        while(left<=right){
            mid = left + (right -left)/2;
            if(nums[mid] == target){
                res = mid;
                right = mid-1;
                
            }
            
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
            
        }
        pos.push_back(res);
        
        left = 0;
        right = len -1;
        res = -1;
        
        while(left<=right){
            mid = left + (right -left)/2;
            if(nums[mid] == target){
                res = mid;
                left = mid+1;
                
            }
            
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
            
        }
        pos.push_back(res);
        return pos;
    }
};