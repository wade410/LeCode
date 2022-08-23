package leetcode.top100;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/17
 **/
public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        List<Integer> subList = new ArrayList<>();
        backTracking(nums, list, subList, 0);
        return list;
    }

    public void backTracking(int[] nums, List<List<Integer>> list, List<Integer> subList, int start) {
        list.add(new ArrayList<>(subList));
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            backTracking(nums, list, subList, i + 1);
            subList.remove(subList.size() - 1);
        }

    }

    public static void backTracking(int[] nums, List<Integer> list, int start) {
        System.out.println(list+"--------------"+start);

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        backTracking(new int[] {1, 2, 3,4,5,6}, new ArrayList<>(), 0);
    }

}
