class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size()-1;
        
        int ans = INT_MIN;//,min=INT_MIN;
        
        while(left<right){
            
            ans = std::max(ans,std::min(height[right],height[left])*(right-left));
            if(height[right]>height[left]) { left+=1;}
            else if(height[right]<height[left]){ right -=1;}
            else{ left+=1;right-=1;}
        }
        return ans;
    }
    
};