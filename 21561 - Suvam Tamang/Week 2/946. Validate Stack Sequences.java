class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int temp = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            j = temp;
            for( ;j<popped.length;j++){
                if(!stack.empty() && stack.peek()==popped[j]){
                    stack.pop();
                    temp = j+1;
                }
                else{
                    break;
                }
            }
        }
        return stack.empty();
    }
}
