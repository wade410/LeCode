package leetcode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/16
 **/
public class L128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest =0;
        for (int num : set){
            if (!set.contains(num-1)){
                int cnt =1;
                int tmp =num;
                while (set.contains(tmp++)){
                    longest=Math.max(cnt++,longest);
                }
            }
        }
        return longest;
    }



}
