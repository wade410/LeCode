package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/9
 **/
public class L79_third {
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;

    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backTracking(i, j, 0, board, word, hasVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTracking(int i, int j, int k, char[][] board, String word, boolean[][] hasVisited) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(k) != board[i][j] || hasVisited[i][j]) {
            return false;
        }
        hasVisited[i][j] = true;
        for (int[] d : direction) {
            int newL = i + d[0];
            int newR = j + d[1];
            if (backTracking(newL, newR, k + 1, board, word, hasVisited)) {
                return true;
            }
        }
        hasVisited[i][j] = false;
        return false;
    }
    public static void main(String[] args) {
        char[][] chars = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(exist(chars,"ABCCED"));
    }

}
