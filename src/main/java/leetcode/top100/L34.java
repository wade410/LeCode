package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/8/2
 **/
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        int last = findFirst(nums,target+1)-1;
        if (first==nums.length||nums[first]!=target){
            return new int[]{-1,-1};
        }else {
            return new int[]{first,last};
        }
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
