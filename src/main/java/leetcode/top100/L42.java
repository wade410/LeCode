package leetcode.top100;

/**
 * @Author HuShengHengao
 * @Date 2022/8/7
 **/
public class L42 {
    /**
     *方法：双指针
     * 巧妙点：两个双指针，一个双指针记录最大值，一个双指针用来遍历。这里有个规律，如果左边的值小，那么左边的最大值，一定比右边值小
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax =0;
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] <height[right]){
                if (height[left]<leftMax){
                   res+=leftMax-height[left++];
                }else {
                    leftMax=height[left++];
                }
            }else {
                if (height[right]<rightMax){
                    res+=rightMax-height[right--];
                }else {
                    rightMax=height[right--];
                }
            }
        }
        return res;
    }

}
