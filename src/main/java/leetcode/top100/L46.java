package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HuWei05
 * @Date 2022/8/8
 **/
public class L46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Boolean[] booleans = new Boolean[nums.length];
        Arrays.fill(booleans,false);
        backtrack(res,nums,new ArrayList<>(),booleans,0);
        return res;
    } 

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, Boolean[] booleans, int index) {
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (booleans[i]==true)
                continue;
            booleans[i]=true;
            list.add(nums[i]);
            backtrack(res,nums,list,booleans,i);
            list.remove(list.size()-1);
            booleans[i]=false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
