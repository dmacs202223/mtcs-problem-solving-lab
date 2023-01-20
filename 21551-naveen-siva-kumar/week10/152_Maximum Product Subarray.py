class Solution {
public: int maxi(int a,int b,int c){
    if(a>b)
        return a>c?a:c;
    else 
        return b>c?b:c;
}
public: int mini(int a,int b,int c){
    if(a<b)
        return a<c?a:c;
    else 
        return b<c?b:c;
}
public:
    int maxProduct(vector<int>& nums) {
        int max,min,max_till_now,temp;
        max=min=max_till_now=nums[0];
        for(int i=1;i<nums.size();i++){
            temp=max;
            max = maxi(nums[i]*max,nums[i]*min,nums[i]);
            min= mini(nums[i]*temp,nums[i]*min,nums[i]);
            max_till_now =std::max(max_till_now,max);
        }
        return max_till_now;
    }
};
