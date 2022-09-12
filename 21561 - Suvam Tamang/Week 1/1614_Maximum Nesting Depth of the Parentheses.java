class Solution {
    public int maxDepth(String s) {
        Stack <Character> stack = new Stack <> ();
        int maxDepth = 0;
        
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
                maxDepth = Math.max(maxDepth, stack.size());
            }
            else if(c == ')'){
                stack.pop();
            }
        }
        return maxDepth;
    }
}
