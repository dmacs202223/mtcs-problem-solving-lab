class Solution {
public:
    int jump(vector<int>& nums) {
        
        int ans=1;
        int l=0,r=nums[0];
        int farthest=0;
        if(nums.size()==1)
            return 0;
        
        while(r<nums.size()-1){
            farthest=0;
            for(int i=l;i<r+1;i++){
                farthest=max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            ans+=1;
        }
        return ans;
    }
};
