class Solution:    
    def longestPalindrome(self, s: str) -> str:
        lenS = len(s)
        # center, start, and end of palindrome
        i, j, k = 0, 0, 0
        # start and length of the desired longest palindrome
        start, maxlen = 0, 0

        # exit when the remaining letters CANNOT be the desired centers
        # (because they would be centers of palindromes shorter than the longest one)
        while lenS - i > maxlen // 2:

            # start from the center to expand outward
            j, k = i, i

            # subsequences with a single character are trivially a palindrome
            while k < lenS-1 and s[k] == s[k+1]:
                k += 1
            i = k+1

            # expand about the center and check if there's a palindrome
            while k < lenS-1 and j and s[j-1] == s[k+1]:
                j -= 1
                k += 1

            # update if the current palindrome is longer than the previous max one
            if k-j+1 > maxlen:
                start, maxlen = j, k-j+1
        
        return s[start : start + maxlen]
