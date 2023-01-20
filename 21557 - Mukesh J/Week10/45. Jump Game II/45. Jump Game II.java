class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int l=0, r=nums[0], jumpcount=0, r_next;
        while(r<nums.length-1)
        {
            r_next=r;
            for(int i=l;i<=r;i++)
            {
                r_next= Math.max(r_next, i+nums[i]);
            }
            jumpcount++;
            l= r+1;
            r= r_next;
        }
        return jumpcount+1;
    }
}
