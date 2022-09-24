class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        
        vector<double> ans;
        multiset<int> ms;

        for(int i=0;i<k;i++){
            ms.emplace(nums[i]);
        }
        double a,b,c;
        int ind1=k/2;
        int ind2=ind1-1;

        if(k%2==0)
        {
            a= *(next(ms.begin(),ind1));
            b= *(next(ms.begin(),ind2));

            c=(a+b)/2;

            ans.push_back(c);
        }
        else{
            a= *(next(ms.begin(),ind1));
            ans.push_back(a);
        }

        
        int j=0;
        for(int i=k;i<nums.size();i++){
            ms.erase(ms.find(nums[j++]));
            ms.emplace(nums[i]);
            if(k%2==0)
            {
                a= *(next(ms.begin(),ind1));
                b= *(next(ms.begin(),ind2));

                c=(a+b)/2;

                ans.push_back(c);
            }
            else{
                a= *(next(ms.begin(),ind1));
                ans.push_back(a);
            }
        }

        return ans;
    }
};