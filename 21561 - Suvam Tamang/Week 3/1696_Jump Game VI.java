class Solution {
    public int maxResult(int[] nums, int k) {
        int result = 0;
        if(nums.length==1)
            return nums[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(nums[0]);
        int i;
        for(i=1;i<nums.length;i++){
            nums[i] = dq.peekFirst() + nums[i];
            while(!dq.isEmpty() && dq.peekLast() < nums[i])
                dq.removeLast();
            dq.offerLast(nums[i]);
            
            if(i>=k && dq.peekFirst() == nums[i-k])
                    dq.removeFirst();
        }
        return nums[i-1];
    }
}
