**Approach Used:**

We construct a matrix depicted by `dp` in the code. We are interested only in the upper triangular part of the matrix. The matrix size would be `n*n`, where `n` is the length of the string. The diagonal entries of the matrix will be marked true as a single character is a palindrome trivially. Now we use this information to determine the palindromes in the given string. 

We have two pointers `i` and `j` between(inclusive) which we would like to determine wherther the string is a palindrome. For `s[i,j]` to be a palindrome two conditions must satisfy:
1. `s[i+1. j-1]` must be a palindrome
2. `s[i] = s[j]`

If the case is for a single letter or two letter, the second condition suffices to determine its palindromic nature else both the above conditions needs to be satisfied for the string to be a palindrome. This is where Dynamic Programming comes to our rescue as the information as to whether the substring in the middle i.e. the first condition is satisfied is memoised and kept in the `dp` matrix. Then it just becomes a matter of checking the matrix for first condition and checking equality of extreme characters for the second condition.

