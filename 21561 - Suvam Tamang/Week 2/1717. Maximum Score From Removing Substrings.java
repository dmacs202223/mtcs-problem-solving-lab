// I've used Greedy Approach for solving the problem
class Solution {
    int gain = 0;
    
    // The function below simply removes string pattern "ab" from the input string and eliminates the same using stack.
    // It also adds the score we get after removing the pattern "ab" to the global gain value.
    public String remove_ab(String s, int score){
        Stack <Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b' && !stack.empty() && stack.peek()=='a'){
                stack.pop();
                gain += score;
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
    
    // The function below simply removes string pattern "ba" from the input string and eliminates the same using stack.
    // It also adds the score we get after removing the pattern "ba" to the global gain value.
    public String remove_ba(String s, int score){
        Stack <Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' && !stack.empty() && stack.peek()=='b'){
                stack.pop();
                gain += score;
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
    
    public int maximumGain(String s, int x, int y) {
        String str1 = "", str2 = "";
        if(s.length()==1){
            return 0;
        }
        else{
            // If x>y then we remove "ab" followed by removing "ba" on the remaining string
            if(x>y){
                str1 = remove_ab(s, x);
                str2 = remove_ba(str1, y);
            }
            // If y>x then we remove "ba" followed by removing "ab" on the remaining string
            else{
                str2 = remove_ba(s, y);
                str1 = remove_ab(str2, x);
            }
        }
       
        return gain;
    }
}
