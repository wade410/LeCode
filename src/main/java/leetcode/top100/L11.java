package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/7/23
 **/
public class L11 {
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i ));
            }
        }
        return maxArea;
    }
    public static int maxAreaOpt(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            int area =Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea,area);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;

    }




    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOpt(height));
    }
}
