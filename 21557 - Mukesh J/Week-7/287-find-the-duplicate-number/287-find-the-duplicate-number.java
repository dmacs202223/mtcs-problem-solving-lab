class Solution {
    public int findDuplicate(int[] nums) {
        int size= nums.length,i;
        int[] check= new int[size];
        for(i=0;i<size;i++)
        {
            if(check[nums[i]]!=0)
                break;
            check[nums[i]]=1;
        }
        return nums[i];
    }
}