package leetcode.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/13
 **/
public class L56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=stack.peek()[1]){
                int[] temp = stack.pop();
                stack.add(new int[]{temp[0],Math.max(intervals[i][1],temp[1])});
            }else {
                stack.add(intervals[i]);
            }
        }
        int n = stack.size();
        int[][] res = new int[n][2];
        while (!stack.isEmpty()){
           res[--n] =stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        int[][] merge = merge(intervals);
        for (int[] ints :merge){
            System.out.println(ints[0]+"------"+ints[1]);
        }
    }
}
