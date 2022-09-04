## Question:
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.


** Example 1: **
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

** Example 2: **
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

** Example 3: **
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

## Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

## Data Structures: 

String, Stack

## Idea:

1. For first string, keep push elements to stacks and when you see ‘#’ just pop the top of the stack.
2. Similarly, Do for second string also.
3. Finally, check whether both stacks are equal.
4. Time: O(n) where n is the length of the string.


## Solution:

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> string1= new Stack<Character>();
        Stack<Character> string2= new Stack<Character>();
        int i;
        char e,d;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='#')
            {
                if(!string1.isEmpty())
                    string1.pop();
            }
            else
                string1.push(s.charAt(i));
        }
        for(i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='#')
            {
                if(!string2.isEmpty())
                    string2.pop();
            }
            else
                string2.push(t.charAt(i));
        }
        return string1.equals(string2);
    }
}
