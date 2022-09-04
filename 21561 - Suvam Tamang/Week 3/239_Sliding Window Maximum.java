class Solution {
   
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] result = new int [nums.length-k+1];
        if(nums.length==1)
            return nums;
        Deque<Integer> Qi = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            while(!Qi.isEmpty() && Qi.peekLast() < nums[i])
                Qi.removeLast();
            Qi.offerLast(nums[i]);
            
            if(i>=(k-1)){
                result[i-k+1] = Qi.peekFirst();
                if(!Qi.isEmpty() && Qi.peekFirst() == nums[i-k+1])
                    Qi.removeFirst();
            }
        }
        return result;
    }
}
