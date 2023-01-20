class Solution {
public:
    int jump(vector<int>& nums) {
        int currEnd = 0,nextEnd = 0,jumps = 0;

        for(int i = 0;i < nums.size() - 1;i++){
            nextEnd = max(nextEnd, i+nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = nextEnd;
            }
        }
        return jumps;
    }
};