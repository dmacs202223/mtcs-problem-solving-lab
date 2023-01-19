class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0, j=n-1,volume=0,max=0;
        while(i<j)
        {
            volume= (j-i)*Math.min(height[j],height[i]);
            if(height[j]<height[i])
                j--;
            else if(height[j]>height[i])
                i++;
            else
            {
                i++;
                j--;
            }
            if(max<volume)
                max=volume;
        }
        return max;
    }
}