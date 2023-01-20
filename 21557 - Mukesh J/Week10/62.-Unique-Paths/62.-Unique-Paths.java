class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path= new int[m][n];
        int i,j;
        for(i=0;i<m;i++)
        {
            path[i][0]=1;
        }
        for(j=0;j<n;j++)
        {
            path[0][j]=1;
        }
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                path[i][j]=path[i][j-1]+path[i-1][j];
            }
        }
        return path[m-1][n-1];
    }
}
