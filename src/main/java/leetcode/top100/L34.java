package leetcode.top100;

/**
 * @Author HuShengHengao
 * @Date 2022/8/2
 **/
public class L34 {
    public static int[] searchRange(int[] nums, int target){
        int leftIndex = searchBinary(nums, target);
        int rightIndex = searchBinary(nums, target + 1) - 1;
        if (leftIndex < nums.length && rightIndex < nums.length && (leftIndex+1 == rightIndex || leftIndex == rightIndex)) {
            return new int[] {leftIndex, rightIndex};
        } else {
            return new int[] {-1, -1};
        }
    }

    public static int searchBinary(int[] nums, int target){
        int left =0;
        int right = nums.length;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }



//    public int[] searchRange(int[] nums, int target) {
//        int first = findFirst(nums,target);
//        int last = findFirst(nums,target+1)-1;
//        if (first==nums.length||nums[first]!=target){
//            return new int[]{-1,-1};
//        }else {
//            return new int[]{first,last};
//        }
//    }
//
//    private int findFirst(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length ;//核心还是这个地方，这里预防这种情况1234566
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;//如果有相同的（例如12234，找2），left肯定是最靠左的
//    }
public static void main(String[] args) {
    System.out.println(searchRange(new int[]{5},5)[1]);
}
}
