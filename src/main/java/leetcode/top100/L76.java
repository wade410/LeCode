package leetcode.top100;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/15
 **/
public class L76 {
    public static String minWindow(String s, String t) {
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        System.out.println(  need[s.charAt(0)]);
        int left = 0, right = 0, n = s.length() - 1;
        int count = t.length();
        int size = Integer.MAX_VALUE;
        int start =0;
        while (right <= n) {
            if ( need[s.charAt(right)]>0){
                count--;
            }
            need[s.charAt(right)]--;
            if (count == 0) {
                while (left<right && need[s.charAt(left)]<0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if (size > right - left+1) {
                    size = right - left+1;
                    start=left;
                }
                need[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));

    }
}
