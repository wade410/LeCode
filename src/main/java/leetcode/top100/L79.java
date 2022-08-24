package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/24
 **/
public class L79 {
    private static int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};
    private static int m,n;
    public static boolean exist(char[][] board, String word) {
        if (board==null||word==null||board.length==0||word.length()==0)
            return false;
        m=board.length;
        n=board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (backtracking( r, c,0, board, word,hasVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean backtracking(int i, int j, int k, char[][] board, String word,boolean[][] hasVisited){
        if (k==word.length())
            return true;
        if (i<0||i>=m||j<0||j>=n||board[i][j]!=word.charAt(k)||hasVisited[i][j])
            return false;
        hasVisited[i][j]=true;
        for (int[] d:direction){
            int nextR=d[0]+i;
            int nextL=d[1]+j;
            if (backtracking(nextR,nextL,1+k,board,word,hasVisited)){
                return true;
            }

        }
        hasVisited[i][j]=false;
        return false;
    }
}
