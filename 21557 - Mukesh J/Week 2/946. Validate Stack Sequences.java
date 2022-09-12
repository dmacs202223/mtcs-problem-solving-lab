Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

 Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

  Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.

  Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.
  
  
  Data Structures: 
Array, Stack.

  Idea:
1. Create a stack named parenthesis. 
2. Push all elements from pushed Array to stack util current pushed array and Popped array elements are equal.
3. If they are equal and stack is not empty and popped pointer is lesser than size, then pop element from stack and increment the popped array pointer.
4. Continue util pushed array reaches it's size.
5. Finally, return whether stack is empty or not.
6. Time: O(N) where N is length of Pushed by Popped. 


  Solution:

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> parenthesis = new Stack<Integer>();
        int j = 0;
        for(int i = 0 ; i < pushed.length ; i++)
        {
            parenthesis.push(pushed[i]);
            while(!parenthesis.isEmpty() && j < popped.length && parenthesis.peek() == popped[j])
            {
                j++;
                parenthesis.pop();
            }
        }
        return parenthesis.isEmpty();
    }
}


  
  
