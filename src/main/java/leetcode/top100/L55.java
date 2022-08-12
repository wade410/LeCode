package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/8/13
 **/
public class L55 {
    /**
     *这个题比较考验智商，
     * 重点就是k的定义，k为从当前起，能够走的最远的距离。
     *
     */
    public boolean canJump(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(i>k)
                return false;
            k=Math.max(k,i+nums[i]);
        }
        return true;

    }
}
