class Solution {
    
    public void heapify(int[] nums, int index, int size)
    {
        int largest= index;
        int left = 2* index + 1;
        int right = 2* index + 2;
        if(left<size && nums[left]>nums[largest])
            largest=left;
        if(right<size && nums[right]>nums[largest])
            largest= right;
        if(largest != index)
        {
            int temp = nums[largest];
            nums[largest]= nums[index];
            nums[index] = temp;
            heapify(nums, largest,size);
        }
    }
    
    public int[] sortArray(int[] nums) {
        int size= nums.length;
        for(int i= (size/2)-1; i>=0; i--)
        {
            heapify(nums,i,size);
        }
        for(int j=size-1;j>=0;j--)
        {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            heapify(nums,0,j);
        }
        return nums;
    }
}