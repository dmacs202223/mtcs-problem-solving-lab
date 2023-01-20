class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int l=0,r=nums.size()-1;
        return helper(nums,l,r);
    }
    
    int helper(vector<int>& nums,int left,int right){
        int size = right+1;
        int mid = (left+right)/2;
        if(size==1){return nums[0];}
        if(size==3){
            if(nums[1]==nums[0])
             return nums[2];
            else
                return nums[0];
        }
        while(left<=right){
            mid = (left+right)/2;
            if(mid==0){
                if(nums[mid]!=nums[mid+1]) return nums[0];
            }
            if(nums[mid-1]!=nums[mid] && nums[mid+1]!=nums[mid] ){
                 return nums[mid];
            }
            else if(mid%2==0 && nums[mid]!=nums[mid+1]){
                //cout<<"here"<<endl;
                right = mid-1;
            }
            else if(mid%2!=0 && nums[mid]!=nums[mid-1]){
                right = mid-1;
            }
            else if(mid%2==0 && nums[mid]==nums[mid+1]){
                left = mid+1;
            }
            else if(mid%2!=0 && nums[mid]==nums[mid-1]){
                //cout<<"and here";
                left = mid+1;
            }
        }
         return nums[left];
    }
};
