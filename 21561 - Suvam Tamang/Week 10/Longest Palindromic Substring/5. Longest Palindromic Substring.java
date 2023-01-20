class Solution {
  // public Boolean checkPalindrome(String s, int i, int j) {
  //   int i1 = i;
  //   int j1 = j;
  //   boolean result = false;
  //   while(true) {
  //     if(i1 == j1 || j1 < i1) {
  //       result = true;
  //       break;
  //     }
  //     if(s.charAt(i1) == s.charAt(j1)) {
  //       i1 ++;
  //       j1--;
  //     } else {
  //       result = false;
  //       break;
  //     }
  //   }
  //   return result;
  // }

	// public String longestPalindrome(String s) {
	// 	int n = s.length();
	// 	int startIndex = 0, endIndex = 0;
  //   boolean result = false;

  //   // Brute Force
  //   for(int i=0; i<n-1; i++) {
  //     for(int j=i+1; j<n; j++) {
  //       result = checkPalindrome(s, i, j);
  //       if(result && j-i > endIndex-startIndex) {
  //         startIndex = i;
  //         endIndex = j;
  //       } 
  //     }
  //   }
  //   return n == 0 ? "" : s.substring(startIndex, endIndex + 1);

    public String longestPalindrome(String s) {
		int n = s.length();
		int startIndex = 0, endIndex = 0;
		boolean[][] dp = new boolean[n][n];
        boolean result = false;

   	    for ( int i=n-1; i>=0;i-- ) {
			for( int j=i; j<n; j++ ) {
				if(s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])) {
          dp[i][j] = true;
        }
				if(dp[i][j] && j-i > endIndex-startIndex ) {
					startIndex = i;
					endIndex = j;
				}
			}
		}
		return n == 0 ? "" : s.substring(startIndex, endIndex + 1);
	}
}
