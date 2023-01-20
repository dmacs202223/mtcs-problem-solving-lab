62. Unique Paths:

Notes:
1. Fill first row with 1 (because only from left you can reach that position).
2. Similarly, fill first column with 1 (because only from up you can reach that position).
3. Check the reachability of the position from top and left.(Add values from top position and left position)
4. Finally, return bottom-right corner value from the 2D array.

Time Complexity : O(N)
Space Complexity: O(N)
