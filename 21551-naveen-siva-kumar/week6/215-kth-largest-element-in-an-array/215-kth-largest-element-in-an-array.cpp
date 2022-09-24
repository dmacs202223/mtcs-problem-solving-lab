class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int left = 0;
        int right = nums.size()-1;
        int tempSwap =0;
        k=nums.size()-k+1;
        int l = left;int r = right;
        return threeWayPartition(nums,k,right,left,tempSwap,l,r);   
    }
    public:
    int threeWayPartition(vector<int>& nums,int& k,int& right,int& left,int& tempSwap,int& l,int& r){
        if(left==right){return nums[left];}
        srand((unsigned) time(NULL));
        int pivotIndex = (rand() % (right-left+1)) + left;
        swap(nums[pivotIndex],nums[right],tempSwap); //Now my last ele is pivot
        int pivot = nums[right];
        cout<<"pivot :"<<pivot<<endl;
        l=left-1;
        for(r=left;r<right;r++){
            if(nums[r]<pivot){
                l++;
                swap(nums[l],nums[r],tempSwap);
            }
        }swap(nums[l+1],nums[right],tempSwap);
        if(l+1 == k-1){
            return nums[l+1];
        }
        else if(l+1 > k-1){
            right = l;
            return threeWayPartition(nums,k,right,left,tempSwap,l,r);
        }
        else{
            left = l+2;
            return threeWayPartition(nums,k,right,left,tempSwap,l,r);
        }
    }
    public:
    void swap(int &a,int &b,int &tempSwap){
        tempSwap =a;
        a=b;
        b=tempSwap;
    }
};