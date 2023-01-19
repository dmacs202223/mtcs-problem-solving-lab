Merge Nodes in Between Zeros
​
* Create two pointers, say slow and fast.
* Traverse fast pointers till you find next zero nodeand add all values.
* Once fast next val is zero, then replace slow value with sum and slow next with fast.
* keep track of last before node, because last node is zero and we need to remove it.
​