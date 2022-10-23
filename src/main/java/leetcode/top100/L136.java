package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/23
 **/
public class L136 {
    public int singleNumber(int[] nums) {
       int temp =nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp^nums[i];
        }
        return temp;

    }
}
