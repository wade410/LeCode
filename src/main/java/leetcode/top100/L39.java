package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuWei05
 * @Date 2022/8/3
 **/
public class L39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        backTrack(candidates, target, new ArrayList<>(), lists, 0, 0);
        return lists;
    }

    private static void backTrack(int[] candidates, int target, ArrayList<Integer> subList, List<List<Integer>> lists,
        int sum, int start) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            lists.add(new ArrayList<>(subList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            subList.add(candidates[i]);
            backTrack(candidates, target, subList, lists, sum, i);
            subList.remove(subList.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }
}
