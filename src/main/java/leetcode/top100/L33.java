package leetcode.top100;

/**
 * @Author HuShengHengao
 * @Date 2022/8/1
 **/
public class L33 {
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[right]>nums[mid]){
                if(nums[right]>=target && nums[mid]<target){
                    left = mid+1;
                }else{
                    right =mid-1;
                }
            }else{
                if(nums[mid]>target && nums[left]<=target){
                    right =mid-1;
                }else{
                    left = mid+1;
                }
            }


            //下面这个却是错的
            //原因是根据left和right算中间值mid的时候，mid总会王左，比如0和1，显然mid等于0，这时如果比较左边，{3,1}这种情况就会出问题
//            if(nums[left]<nums[mid]){
//                if(nums[mid]>target && nums[left]<=target){
//                    right =mid-1;
//                }else{
//                    left = mid+1;
//                }
//            }else{
//                if(nums[right]>=target && nums[mid]<target){
//                    left = mid+1;
//                }else{
//                    right =mid-1;
//                }
//            }



        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));
    }
}
