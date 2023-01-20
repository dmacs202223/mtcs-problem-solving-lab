**Idea**
The idea behind solving this problem using DP is pretty straightforward. Instead of seeing the problem as seeing the numeric array values and taking the jumping step based on their magnitude, why don't we see this problem as taking the array values to determine the number of steps that can be taken next. We'll simply take these array values as the hint to take the number of steps to be taken and simply return the minimum number of steps that can be taken to reach the end of the array ie nums[n-1] where, n: the length of the array.

So, we keep a track of the minimum distance that it takes to reach the end of the array with the help of an array in the code it is min_dist array. It has been intialized as:
```
			for(int i=1; i<n; i++) {
					min_dist[i] = Integer.MAX_VALUE;
			}							
```
Thus, inititally minimum steps it takes to reach the first array posiiton i.e. 0 posiiton is 0. For all the other position elements the minimum number of steps taken is infinity. 
```
			for(int i=0; i<n; i++) {
					for(int j=i; j<=i+nums[i] && j<n; j++) {
							min_dist[j] = Math.min(min_dist[j], min_dist[i]+1);
					}
			}
```
The above two loops ensures that for every array element we always store the monimum number of steps it takes to reach that position from the start array element. 
