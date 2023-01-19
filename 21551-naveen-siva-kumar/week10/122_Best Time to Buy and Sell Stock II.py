class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int sum=0,diff=0;
        for(int i=1;i<prices.size();i++){
            diff=prices[i]-prices[i-1];
            if(diff>0)
                sum+=diff;
        }
        return sum;
        
    }
};
