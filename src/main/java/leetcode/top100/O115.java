package leetcode.top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author HuShengHengao
 * @Date 2022/7/23
 **/
public class O115 {
    public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Set> d = new HashMap<>();
        for (int[] x : sequences) {
            for (int i = 1; i < x.length; i++) {
                d.putIfAbsent(x[i - 1], new HashSet<Integer>());
                d.get(x[i - 1]).add(x[i]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (!d.getOrDefault(nums[i - 1], new HashSet<Integer>()).contains(nums[i]))
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[][] sequences = {{1,2},{1,3},{2,3}};
        System.out.println(sequenceReconstruction(nums,sequences));
    }
}
