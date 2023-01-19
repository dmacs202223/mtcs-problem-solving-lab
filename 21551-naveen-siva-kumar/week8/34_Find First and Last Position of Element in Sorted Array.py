class Solution {

    public:
    int left_bs(vector<int>& nums, int target){
        if(nums.size()==0) return -1;
        int left =0;
        int right = nums.size()-1;
        int mid = (right+left)/2;
        int ans=INT_MAX;
        while(left<=right){
            //cout<<"iamhere"<<endl;
            mid = (right+left)/2;
            
            if(target<nums[mid]){
                right = mid-1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
                right=mid-1;
                ans = mid;
                cout<<"mid "<<mid<<"right "<<right<<"left "<<left<<endl;
            }
        }
        return ans==INT_MAX?-1:ans;
        
    }
     public:
    int right_bs(vector<int>& nums, int target){
        if(nums.size()==0) return -1;
        
        int left =0;
        int right = nums.size()-1;
        int mid = (right+left)/2;
        int ans=INT_MAX;
        while(left<=right){
            //cout<<"iamhere"<<endl;
            mid = (right+left)/2;
            if(target<nums[mid]){
                right = mid-1;
            }
            else if(target>nums[mid]){
                left = mid+1;
            }
            else{
                left = mid+1;
                ans = mid;
                cout<<"mid "<<mid<<"right "<<right<<"left "<<left<<endl;
            }
        }
         return ans==INT_MAX?-1:ans;
        
    }
    public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;
        ans.push_back(left_bs(nums,target));
        ans.push_back(right_bs(nums,target));
        return ans;
    }
};
