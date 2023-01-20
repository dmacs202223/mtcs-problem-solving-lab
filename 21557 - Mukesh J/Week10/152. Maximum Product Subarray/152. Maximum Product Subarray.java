class Solution {
    public int maxProduct(int[] nums) {
        int minprod= nums[0], maxprod= nums[0], result= nums[0], temp;
        for(int i=1;i<nums.length;i++)
        {
            temp= maxprod;
            maxprod= Math.max(Math.max(maxprod*nums[i], minprod*nums[i]), nums[i]);
            minprod= Math.min(Math.min(temp*nums[i], minprod*nums[i]),nums[i]);
            if(maxprod>result)
                result= maxprod;
        }
        return result;
    }
}
