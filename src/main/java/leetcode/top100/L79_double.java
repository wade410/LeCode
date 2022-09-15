package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/9/15
 **/
public class L79_double {
    private static final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static  int m = 0, n = 0;

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTracking(i, j, 0, hasVisited, board, word))
                    return true;
            }
        }
        return false;
    }

    private static boolean backTracking(int i, int j, int k, boolean[][] hasVisited, char[][] board, String word) {
        if (k == word.length())
            return true;
        if (i >= m || i < 0 || j >= n || j < 0 || word.charAt(k) != board[i][j] || hasVisited[i][j])
            return false;
        hasVisited[i][j] = true;
        for (int[] d :direction) {
            int nextL=d[0]+i;
            int nextR=d[1]+j;
            if (backTracking(nextL,nextR,k+1,hasVisited,board,word))
                return true;
        }
        hasVisited[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(exist(chars,"ABCCED"));
    }


}
