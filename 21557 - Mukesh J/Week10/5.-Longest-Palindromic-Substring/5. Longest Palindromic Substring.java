class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = 0;
        boolean[][] isPali = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) 
        {
            for (int j = i; j < s.length(); j++) 
            {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPali[i + 1][j - 1])) 
                {
                    isPali[i][j] = true;
                    if (j - i + 1 > len) 
                    {
                        result = s.substring(i, j + 1);
                        len = j - i + 1;
                    }
                }
            }
        }
        return result;
    }
}
