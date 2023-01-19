class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();
        int left,right;
        left = 0;
        right = n-1;
        
        int max_water = 0;
        
        
        while(left < right){
            int vL = height[left];
            int vR = height[right];
        
            if(vL < vR){
                max_water = max(max_water, vL*(right - left));
                left = left+1;
            }
            else
            {
                max_water = max(max_water, vR*(right - left));
                right = right - 1;
            }
        }
        
        return max_water;
        
    }
};