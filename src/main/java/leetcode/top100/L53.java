package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/8/12
 **/
public class L53 {
    public int maxSubArray(int[] nums) {
        if (nums==null)
            return 0;
        int max=nums[0];
        int cur =nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (cur<0){
                cur=nums[i];
            }else {
                cur=cur+nums[i];
            }
            max=Math.max(max,cur);
        }
        return max;
    }
}
