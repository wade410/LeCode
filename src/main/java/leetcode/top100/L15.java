package leetcode.top100;

import java.util.*;

/**
 * @Author HuShengHenGao
 * @Date 2022/7/24
 **/
public class L15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int temp = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left<right){
                int sum = nums[left]+nums[right]+temp;
                if (sum==0){
                    res.add(Arrays.asList(temp, nums[left], nums[right]));
                    while (left + 1 < n && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (right-1>0 && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;

                }else if (sum<0){
                    while (left + 1 < n && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }else {
                    while (right-1>0 && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
