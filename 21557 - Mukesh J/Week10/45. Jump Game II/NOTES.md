45. Jump Game II:

Notes:
1. Initialize l and r for current jump's range. 
2. calculate r_next  from the range which will jump more steps.
3.  Once calculated, Increment the jumpcount and shift the range from r+1 to r_next.
4.  Continue utill r crosses the array length.
5.  Then, return jump count by incrementing with 1.

Time Complexity: O(N)
Space Complexity: O(1).
