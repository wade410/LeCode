package leetcode.top100;

import java.util.Arrays;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/13
 **/
public class L62 {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] dp = new int[m][n];
        for (int i = 1; i < n; i++) {
            dp[0][i] =  1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] =  1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j]+ dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
    public static int uniquePathsOpt(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePathsOpt(3,2));
    }
}
