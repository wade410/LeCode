package leetcode.top100;

/**
 * @Author HuWei05
 * @Date 2022/7/18
 **/
public class L4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLen = length1 + length2;
        if (totalLen % 2 == 1) {
            int mid = totalLen / 2 + 1;
            return getKthElement(nums1, nums2, mid);
        } else {
            int mid1 = totalLen / 2;
            int mid2 = mid1 + 1;
            return (getKthElement(nums1, nums2, mid1) + getKthElement(nums1, nums2, mid2)) / 2.0;

        }

    }

    private double getKthElement(int[] nums1, int[] nums2, int mid) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int len1 = 0;
        int len2 = 0;
        while (true) {
            if (len1 == length1) {
                return nums2[len2 + mid-1];
            }
            if (len2 == length2) {
                return nums1[len1 + mid-1];
            }
            if (mid == 1) {
                return Math.min(nums1[len1], nums2[len2]);
            }
            int f = mid / 2;
            int newLen1 = Math.min(len1 + f, length1)-1;
            int newLen2 = Math.min(len2 + f, length2)-1;
            if (nums1[newLen1]<=nums2[newLen2]){
                mid-=newLen1- len1+1;
                len1 = newLen1+1;
            }else {
                mid-=newLen2- len2+1;
                len2 = newLen2+1;

            }
            
        } 
    }
}
