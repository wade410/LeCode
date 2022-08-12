package leetcode.top100;

/**
 * @Author HuShengHengao
 * @Date 2022/7/31
 **/
public class L31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        //从后至前遍历查询，找到第一个相邻元素递增的下标
        int i = len-1;
        for (; i >0 ; i--) {
            if (nums[i]>nums[i-1]){
                break;
            }
        }
        //i等于0，曾全部翻转
        if (i==0){
            reverse(nums,0,len);
            return;
        }
        int left = i-1;
        int right= i;
        //找到降序序列中，第一个比nums[left]大的数
        for (i=len-1;i>right;i--){
            if (nums[i]>nums[left]){
                break;
            }
        }
        //交换
        int temp =nums[left];
        nums[left]=nums[i];
        nums[i]=temp;
        //余下的翻转
        reverse(nums,left+1,len);
    }

    /**
     对nums数组从[lo,hi)进行反转，如nums={3,6,9,8,2,10},reverse(nums,1,4) 则nums将会变成{3,8,9,6,2,10}
     */
    public static void reverse(int[] nums, int lo, int hi){
        int len = hi-lo;
        int temp=0;
        for(int j =lo ;j<lo+len/2;j++){
            temp = nums[j];
            nums[j]=nums[lo+hi-1-j];
            nums[lo+hi-1-j]=temp;
        }
    }

}
