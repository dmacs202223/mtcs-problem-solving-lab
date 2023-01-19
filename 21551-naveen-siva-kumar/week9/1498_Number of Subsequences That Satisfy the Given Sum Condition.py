class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
       int len=nums.size();
        int left=0,right=len-1;
        int res=0;
        vector<int> pow2(len,0);
        
        sort(nums.begin(),nums.end());
       
        pow2[0]=1;
        for(int i=1;i<len;i++)
            pow2[i]=(2*pow2[i-1])%(1000000007);
        
        
        while(left<=right){
              
            if(nums[left]+nums[right]<=target){
                res=(res+pow2[right-left])%1000000007;
                left++;
            }else
                right--;
        }
        return res; 
    }
};
