The basic idea is that at a given index, the maximum product can be as follows:
1. The number at the index itself.
2. The product of the number at the index and the maximum product found so far.
3. The product of the number at the index and the minimum product found so far(- * - = +).

The following code section captures the points as discussed above.
```
	for(int i=1; i<n; i++) {
		int temp = local_max;
		local_max = Math.max(temp * nums[i], Math.max(local_min * nums[i], nums[i]));
		local_min = Math.min(temp * nums[i], Math.min(local_min * nums[i], nums[i]));

		global_max = Math.max(local_max, global_max);
	}
```
