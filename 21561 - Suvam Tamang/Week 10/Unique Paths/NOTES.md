**Approach Used**

Since the robot can move either to the right or down each of the top cells can be reached in a single step. The same logic holds for the cells belonging to the first column of the grid.

So we intialize a `dp` matrix with all `1s` in the top row and the first column. Given the constraints as to how a robot can make its move in the grid the `dp` relation becomes pretty straighforward which is:
```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```
Of course `i` and `j` must start from 1 given that the grid is 0 indexed.
