class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        if(arr.size() == k){return arr;}
        
        int index = bs(arr,x,k);
        vector<int> ans;
        cout<<"index :"<<index<<endl;
        for(int i=index;i<index+k;i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }
    int bs(vector<int>& arr, int x,int k){
        int l =0,r=arr.size()-k;
        int mid;
        while(l<r){
            mid=((r+l)/2);
            if(x - arr[mid] > arr[mid + k] - x){
                l= mid+1;
            }
            else{
                r = mid;
            }
        }
        return l;
    }
};
