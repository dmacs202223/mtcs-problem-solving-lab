152. Maximum Product Subarray:

Notes:
1. Keep track of minproduct (because negative * negative = positive), maxproduct, resultant product.
2. At every stage, calculate minimum product, maximum product.
3. Finally, return maximum product.

Time Complexity: O(N).
Space Complexity: O(N).
