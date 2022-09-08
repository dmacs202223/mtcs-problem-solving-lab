Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.


  Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.

  Example 2:

Input: s = "())"
Output: 0
Explanation: The string is already balanced.

  Example 3:

Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 

Constraints:

1 <= s.length <= 105
s consists of '(' and ')' only.


  Data Structure:

Stack, String, Array.
  
  Idea:

1. Convert the given string to Char Array and create a Stack.
2. if the left parenthesis is found, then push it into the stack.
3. if right parenthesis is found and stack is empty, then
     -> add 2 to count if it is the last element in the string.
     -> add 1 to count if the next element is ')'.
     -> add 2 to count if the next element is '('.
4. Similar cases apply for right parenthesis and stack is not empty.
5. After traversing the full string, if the stack is still not empty, then find the size of the stack and add double of the size to count.
6. Finally, return count.
7. Time: O(N) where N is the length of the string.

Solution:

class Solution {
    public int minInsertions(String s) {
        char[] brackets = s.toCharArray();
        Stack<Character> parenthesis = new Stack<>(); 
        int count=0;
        for(int i=0; i<s.length(); i++)
        {
            if(brackets[i] == '(') 
            {
                parenthesis.push(brackets[i] );
            }
            else { 
                if(parenthesis.size() == 0)
                {
                    if(i==s.length()-1)
                    {
                        count += 2;
                    }
                    else if(brackets[i + 1] == ')')
                    {
                        i++;
                        count += 1;
                    }
                    else 
                    {
                        count += 2;
                    }
                    
                }
                else
                {
                    if(i == s.length() - 1)
                    {
                        count += 1;
                    }
                    else if(brackets[i + 1] == ')')
                    {
                        i++;
                    }
                    else
                    {
                        count += 1;
                    }
                    parenthesis.pop();
                }
            }
        }
        int size = parenthesis.size();
        if(!parenthesis.isEmpty())
        {
            count += size * 2;
        }
        return count;
    }
}

  
