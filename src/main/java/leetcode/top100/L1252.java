package leetcode.top100;

/**
 * @Author HuShengHengao
 * @Date 2022/7/13
 **/
public class L1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] dp = new int[m][n];
        for(int i =0;i<indices.length;i++){
            int row = indices[i][0];
            int col = indices[i][1];
            for(int j=0;j<n;j++){
                dp[row][j]+=1;
            }
            for(int j=0;j<m;j++){
                dp[j][col]+=1;
            }
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]%2==1)
                    cnt++;
            }
        }
        return cnt;
    }
    public int oddCellsOpt(int m, int n, int[][] indices){
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i =0;i<indices.length;i++){
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((rows[j]+cols[i])%2==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }

}
