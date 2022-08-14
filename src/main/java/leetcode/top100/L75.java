package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/14
 **/
public class L75 {
    public static void sortColors(int[] nums) {
        if(nums==null || nums.length==0)
            return ;
        int left=0,right=nums.length-1;
        for(int i=0;i<nums.length && i<=right;i++){
            int temp =nums[i];
            if(nums[i]==0){
                nums[i]=nums[left];
                nums[left++]=temp;
            }else if(nums[i]==2){
                nums[i]=nums[right];
                nums[right--]=temp;
                i--;
            }
        }
    }
    public static void sortColorsOpt(int[] nums) {
        int left=0,i=0,right =nums.length-1;
        while (i<=right){
            int temp = nums[i];
            if (nums[i]==0){
                nums[i++]=nums[left];
                nums[left++]=temp;
            }else if (nums[i]==2){
                nums[i] = nums[right];
                nums[right--]=temp;
            }else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }

    public static void main(String[] args) {
        sortColorsOpt(new int[]{1,2,0});
    }
}
