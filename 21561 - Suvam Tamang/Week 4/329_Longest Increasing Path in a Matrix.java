public class Solution {

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return 0;

		int max = 0, m = matrix.length, n = matrix[0].length;

		// create a temp matrix
		int[][] temp = new int[m][n];

		// dfs search on every element in matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, m, n, temp), max);
			}
		}
		return max;
	}

	int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] temp) {

		// check boundary limits
		if (i < 0 || j < 0 || i >= m || j >= n)
			return 0;

		// check min condition
		if (matrix[i][j] <= min)
			return 0;

		// check into cache
		if (temp[i][j] != 0)
			return temp[i][j];

		// update min
		min = matrix[i][j];

		// run dfs in all four directions
		int a = dfs(matrix, min, i - 1, j, m, n, temp) + 1;
		int b = dfs(matrix, min, i + 1, j, m, n, temp) + 1;
		int c = dfs(matrix, min, i, j - 1, m, n, temp) + 1;
		int d = dfs(matrix, min, i, j + 1, m, n, temp) + 1;

		// find max and update cache
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		temp[i][j] = max;

		return max;
	}
}
