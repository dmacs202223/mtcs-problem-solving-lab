class Solution {
    
    public:
        void heapify(vector<int>& nums, int n, int i) {
    
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        //for a given index i,its left child is at 2i+1 position and right child is in 2i+2 position
        //constraint is indices should not go out of bound
        //see if left or right child is larger than root if yes then swap and continue this process(perculate down)
            
        //main-idea is if a change is happenning in the tree then it will happen only on one side so we call heapify only on the position where this perculation took place.
        
        if (left < n && nums[left] > nums[largest])
            largest = left;
  
        if (right < n && nums[right] > nums[largest])
            largest = right;
  
        if (largest != i) {
            swap(nums[i], nums[largest]);
            heapify(nums, n, largest);
        }
    }
    
  public:
    void swap(int &a,int &b){
        int temp=b;
        b=a;
        a=temp;
    }
  public:  
    void heapSort(vector<int>& nums, int n) {
    
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(nums[0], nums[i]);
            heapify(nums, i, 0);
        }
    }
    
    
public:
    vector<int> sortArray(vector<int>& nums) {
        //heap sort using top down approach
        
        heapSort(nums,nums.size());
        return nums;
    }
    
    
    

    
    
};