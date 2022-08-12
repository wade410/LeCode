package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuShengHenGao
 * @Date 2022/7/21
 **/
public class L1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                subList.add(0);
            }
            lists.add(subList);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex  = (i*n+j+k)%(m*n);
                lists.get(newIndex/n).set(newIndex%n,grid[i][j]);
            }
        }
        return lists;
    }
}
