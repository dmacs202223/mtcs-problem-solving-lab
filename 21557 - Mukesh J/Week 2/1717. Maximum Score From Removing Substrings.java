You are given a string s and two integers x and y. You can perform two types of operations any number of times.
Remove substring "ab" and gain x points.

  For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.

  For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

  Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

  Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

  Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.


  Data Structure: 

Stack, Array.

  Idea:
1. Convert given string to char Array.
2. Initialize two stacks.
3. Find first highest points substring (ab) and insert character to stack if ab is not formed.
4. If ab is formed, then pop the element and increase the points.
5. Now, For checking substring (ba) use second stack.
6. if ba is not formed, then pop from stack and push it to stack2.
7. else increase the points and pop the element.
8. Once stack is empty, then return total.
9. Time: O(N) where N is the length of the string.
  
  Solution:

class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] letters= s.toCharArray();
        int total=0;
        boolean abpoints = (x>y);
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>(); 
        for(int i=0;i<letters.length;i++)
        {
            if(!stack.isEmpty()) 
            {
                if(abpoints) 
                {
                    if(stack.peek() == 'a' && letters[i] == 'b') 
                    {
                        total += x;
                        stack.pop();
                    } 
                    else 
                    {
                        stack.push(letters[i]);
                    }
                } 
                else 
                {
                    if(stack.peek() == 'b' && letters[i] == 'a') 
                    {
                        total += y;
                        stack.pop();
                    } 
                    else 
                    {
                        stack.push(letters[i]);
                    }
                }
            } 
            else 
            {
                stack.push(letters[i]);
            }
            //System.out.println(stack);
        }
        
        while(!stack.isEmpty()) 
        {
            char ch = stack.pop(); 
            if(!stack2.empty())
            {
                if(!abpoints)
                {
                    if(stack2.peek() == 'b' && ch == 'a')
                    {
                        total += x;
                        stack2.pop();
                    }
                    else
                    {
                        stack2.push(ch);
                    }
                }
                else
                {
                    if(stack2.peek() == 'a' && ch == 'b')
                    {
                        total += y;
                        stack2.pop();
                    }
                    else
                    {
                        stack2.push(ch);
                    }
                }
            }
            else
            {
                stack2.push(ch);
            }
            //System.out.println(stack2);
        }
        return total;
    }
}

