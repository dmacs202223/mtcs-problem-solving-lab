class Solution {
public:
    vector<double> medianSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        multiset<int> slider(nums.begin(), nums.begin() + k);
        auto mid = next(slider.begin(), k / 2);
        vector<double> ans;
        
        for (int i=k; ; i++) {

        // Push the current median.
        ans.push_back((double(*mid) + *prev(mid, 1 - k%2)) /2);
            
        if(i == n)
            break;
        // Insert nums[i].
        slider.insert(nums[i]);
        // multiset<int>::iterator j;
        //for(j = slider.begin();j != slider.end();j++)
          //  cout<<*j<<"\t";
        if (nums[i] < *mid)
            mid--;
        // cout<<*mid<<endl;
        // Erase nums[i-k].
        if (nums[i-k] <= *mid)
            mid++;
        //cout<<*mid<<endl;
        slider.erase(slider.lower_bound(nums[i-k]));
    }
        
        return ans;
    }
};